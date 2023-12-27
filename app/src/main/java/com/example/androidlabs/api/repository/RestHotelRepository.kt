package com.example.androidlabs.api.repository


import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.androidlabs.AppContainer
import com.example.androidlabs.DB.AppDatabase
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.businessLogic.repository.HotelRepImpl
import com.example.androidlabs.businessLogic.repository.HotelRepository
import com.example.androidlabs.businessLogic.repository.RemoteKeysRepositoryImpl
import com.example.androidlabs.api.BackendService
import com.example.androidlabs.api.HotelRemoteMediator
import com.example.androidlabs.api.model.toHotel
import com.example.androidlabs.api.model.toHotelRemote

import kotlinx.coroutines.flow.Flow

class RestHotelRepository(
    private val service: BackendService,
    private val dbHotelRepository: HotelRepImpl,
    private val database: AppDatabase,
    private val dbRemoteKeyRepository: RemoteKeysRepositoryImpl

) : HotelRepository {

    override fun getAllHotels(): Flow<PagingData<Hotel>> {
        val pagingSourceFactory = { dbHotelRepository.getAllHotelsPagingSource() }

        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(
                pageSize = AppContainer.LIMIT,
                enablePlaceholders = false
            ),
            remoteMediator = HotelRemoteMediator(
                service,
                dbHotelRepository,
                database,
                dbRemoteKeyRepository,
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun search(str: String): Flow<PagingData<Hotel>> {
        return dbHotelRepository.search(str)
    }

    override suspend fun getHotelById(id: Int): Hotel = service.getHotel(id).toHotel()
    override suspend fun insertHotel(hotel: Hotel) {
        service.createHotel(hotel.toHotelRemote())
    }

    override suspend fun updateHotel(hotel: Hotel) {
        hotel.hotelId?.let { service.updateHotel(it, hotel.toHotelRemote()) }
    }

    override suspend fun deleteHotel(hotel: Hotel) {
        hotel.hotelId?.let { service.deleteHotel(it) }
    }
}