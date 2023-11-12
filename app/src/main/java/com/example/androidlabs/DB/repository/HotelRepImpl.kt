package com.example.androidlabs.DB.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.androidlabs.DB.dao.HotelDao
import com.example.androidlabs.DB.models.Hotel
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow


class HotelRepImpl (private val hotelDao: HotelDao) : HotelRepository {

    override suspend fun insertHotel(hotel: Hotel) = hotelDao.insert(hotel)

    override suspend fun updateHotel(hotel: Hotel) = hotelDao.update(hotel)

    override suspend fun deleteHotel(hotel: Hotel) = hotelDao.delete(hotel)

    override suspend fun getHotelById(id: Int): Hotel = hotelDao.getHotelById(id)
    override fun getAllHotelsPaged(): PagingSource<Int, Hotel> = hotelDao.getAllHotelsPaged()
    override fun call(): Flow<PagingData<Hotel>> {
        return Pager(
            PagingConfig(pageSize = 5)
        ) {
            hotelDao.getAllHotelsPaged()
        }.flow
    }
}