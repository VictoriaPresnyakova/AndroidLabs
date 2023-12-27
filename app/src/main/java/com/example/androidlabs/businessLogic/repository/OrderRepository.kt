package com.example.androidlabs.businessLogic.repository

import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.DB.models.Order
import com.example.androidlabs.DB.models.UserWithOrder
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    suspend fun createOrder(order: Order): Long
    suspend fun delete(orderId: Int)
    //fun getAllOrder(): Flow<List<Order>>
    suspend fun getHotelFromOrder(id: Int): Hotel

    suspend fun getUserOrders(id: Int) : Flow<List<Order>>
}