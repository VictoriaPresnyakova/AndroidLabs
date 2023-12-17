package com.example.androidlabs.api

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.androidlabs.DB.AppDatabase
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.DB.models.RemoteKeyType
import com.example.androidlabs.DB.models.RemoteKeys
import com.example.androidlabs.DB.repository.HotelRepImpl
import com.example.androidlabs.DB.repository.RemoteKeysRepositoryImpl
import com.example.androidlabs.api.model.toHotel

import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class HotelRemoteMediator(
    private val service: BackendService,
    private val hotelRepository: HotelRepImpl,
    private val database: AppDatabase,
    private val dbRemoteKeyRepository: RemoteKeysRepositoryImpl
) : RemoteMediator<Int, Hotel>() {
    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Hotel>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: 1
            }

            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                remoteKeys?.prevKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }

            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                remoteKeys?.nextKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
        }

        try {
            val sneakers = service.getHotels(page, state.config.pageSize).map { it.toHotel() }
            val endOfPaginationReached = sneakers.isEmpty()
            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    dbRemoteKeyRepository.deleteRemoteKey(RemoteKeyType.SNEAKER)
                    hotelRepository.clearHotels()
                }
                val prevKey = if (page == 1) null else page - 1
                val nextKey = if (endOfPaginationReached) null else page + 1
                val keys = sneakers.map {
                    RemoteKeys(
                        entityId = it.hotelId!!,
                        type = RemoteKeyType.SNEAKER,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                }
                dbRemoteKeyRepository.createRemoteKeys(keys)
                hotelRepository.insertHotels(sneakers)
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Hotel>): RemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { hotel ->
                hotel.hotelId?.let { dbRemoteKeyRepository.getAllRemoteKeys(it, RemoteKeyType.SNEAKER) }
            }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Hotel>): RemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { hotel ->
                hotel.hotelId?.let { dbRemoteKeyRepository.getAllRemoteKeys(it, RemoteKeyType.SNEAKER) }
            }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, Hotel>
    ): RemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.hotelId?.let { hotelUid ->
                dbRemoteKeyRepository.getAllRemoteKeys(hotelUid, RemoteKeyType.SNEAKER)
            }
        }
    }
}