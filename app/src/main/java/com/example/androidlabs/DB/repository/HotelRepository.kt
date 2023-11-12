package com.example.androidlabs.DB.repository

import androidx.paging.PagingSource
import com.example.androidlabs.DB.models.Hotel
import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
interface HotelRepository {
    suspend fun insertHotel(hotel: Hotel)
    suspend fun updateHotel(hotel: Hotel)
    suspend fun deleteHotel(hotel: Hotel)
    suspend fun getHotelById(id: Int): Hotel
    fun getAllHotelsPaged(): PagingSource<Int, Hotel>
    fun call(): Flow<PagingData<Hotel>>
}