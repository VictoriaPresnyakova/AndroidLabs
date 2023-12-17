package com.example.androidlabs.api.repository

import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.DB.models.Order
import com.example.androidlabs.DB.repository.OrderRepository
import com.example.androidlabs.api.BackendService
import com.example.androidlabs.api.model.toHotel
import com.example.androidlabs.api.model.toOrder
import com.example.androidlabs.api.model.toOrderRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class RestOrderRepository(private val service: BackendService): OrderRepository {
    override suspend fun createOrder(order: Order): Long {
        return service.createOrder(order.toOrderRemote())
    }


    override suspend fun delete(orderId: Int) {
        service.deleteOrder(orderId)
    }

    override suspend fun getHotelFromOrder(id: Int): Hotel {
        return service.getHotelFromOrder(id).toHotel()
    }

    override suspend fun getUserOrders(id: Int): Flow<List<Order>> {
        val ordersRemoteList = service.getUserOrders(id)
        val ordersList = ordersRemoteList.map { it.toOrder() }
        return flowOf(ordersList.toList())
    }
}