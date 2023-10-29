package com.example.androidlabs.DB.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidlabs.DB.models.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    @Insert
    suspend fun createOrder(order: Order): Long

    @Query("SELECT * FROM 'Order' WHERE orderId = :id")
    fun getOrder(id: Int): Order

    @Query("SELECT * FROM `Order`")
    fun getAllOrder(): Flow<List<Order>>

    @Delete
    suspend fun delete(order: Order)
}