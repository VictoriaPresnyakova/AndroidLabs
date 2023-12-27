package com.example.androidlabs.businessLogic.repository

import androidx.paging.PagingSource
import com.example.androidlabs.DB.models.Hotel
import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
interface HotelRepository {
    suspend fun insertHotel(hotel: Hotel)
    suspend fun updateHotel(hotel: Hotel)
    suspend fun deleteHotel(hotel: Hotel)
    suspend fun getHotelById(id: Int): Hotel
    fun search(str: String): Flow<PagingData<Hotel>>

    fun getAllHotels(): Flow<PagingData<Hotel>>

}