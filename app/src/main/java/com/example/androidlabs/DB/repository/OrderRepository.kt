package com.example.androidlabs.DB.repository

import com.example.androidlabs.DB.models.Order
import com.example.androidlabs.DB.models.UserWithOrder
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    suspend fun createOrder(order: Order): Long
    suspend fun delete(order: Order)
    fun getAllOrder(): Flow<List<Order>>
    fun getUserOrders(id: Int) : Flow<UserWithOrder>
}