package com.example.androidlabs.DB.dao
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.androidlabs.DB.models.Hotel
import kotlinx.coroutines.flow.Flow

@Dao
interface HotelDao {
    @Insert
    suspend fun insert(hotel: Hotel)

    @Update
    suspend fun update(hotel: Hotel)

    @Delete
    suspend fun delete(hotel: Hotel)

    @Query("SELECT*FROM Hotel")
    fun getAllHotelsPaged(): PagingSource<Int, Hotel>

    @Query("SELECT * FROM Hotel WHERE hotelId = :id")
    suspend fun getHotelById(id: Int): Hotel
}