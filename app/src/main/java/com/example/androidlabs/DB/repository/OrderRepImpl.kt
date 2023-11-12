package com.example.androidlabs.DB.repository

import com.example.androidlabs.DB.dao.OrderDao
import com.example.androidlabs.DB.models.Order
import com.example.androidlabs.DB.models.UserWithOrder
import kotlinx.coroutines.flow.Flow

class OrderRepImpl (private val orderDao: OrderDao) : OrderRepository {

    override suspend fun createOrder(order: Order): Long = orderDao.createOrder(order)

    override suspend fun delete(order: Order) = orderDao.delete(order)

    override fun getAllOrder(): Flow<List<Order>> = orderDao.getAllOrder()

    override fun getUserOrders(id: Int): Flow<UserWithOrder> = orderDao.getUserOrders(id)
}