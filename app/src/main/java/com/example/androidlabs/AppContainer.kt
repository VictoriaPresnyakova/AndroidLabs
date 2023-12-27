package com.example.androidlabs

import com.example.androidlabs.businessLogic.repository.HotelRepository
import com.example.androidlabs.businessLogic.repository.OrderRepository
import com.example.androidlabs.businessLogic.repository.UserRepository

interface AppContainer {
    val hotelRepo: HotelRepository
    val userRepo: UserRepository
    val orderRepo: OrderRepository
    companion object {
        const val TIMEOUT = 5000L
        const val LIMIT = 10
    }
}