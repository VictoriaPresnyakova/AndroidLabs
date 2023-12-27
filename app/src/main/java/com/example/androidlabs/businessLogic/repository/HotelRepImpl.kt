package com.example.androidlabs.businessLogic.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.androidlabs.DB.dao.HotelDao
import com.example.androidlabs.DB.models.Hotel
import androidx.paging.PagingSource
import com.example.androidlabs.AppContainer
import kotlinx.coroutines.flow.Flow


class HotelRepImpl (private val hotelDao: HotelDao) : HotelRepository {

    override suspend fun insertHotel(hotel: Hotel) = hotelDao.insert(hotel)

    override suspend fun updateHotel(hotel: Hotel) = hotelDao.update(hotel)

    override suspend fun deleteHotel(hotel: Hotel) = hotelDao.delete(hotel)

    override suspend fun getHotelById(id: Int): Hotel = hotelDao.getHotelById(id)
    override fun getAllHotels(): Flow<PagingData<Hotel>> = Pager(
        config = PagingConfig(
            pageSize = AppContainer.LIMIT,
            enablePlaceholders = false
        ),
        pagingSourceFactory = hotelDao::getAll
    ).flow

    suspend fun clearHotels() = hotelDao.deleteAll()
    suspend fun insertHotels(hotels: List<Hotel>) =
        hotelDao.insert(*hotels.toTypedArray())

    override fun search(str: String): Flow<PagingData<Hotel>> {
        return Pager(
            PagingConfig(
                pageSize = AppContainer.LIMIT,
                enablePlaceholders = false
            ),
        ) {
            hotelDao.findHotelsByName(str)
        }.flow
    }

    fun getAllHotelsPagingSource(): PagingSource<Int, Hotel> = hotelDao.getAll()
}