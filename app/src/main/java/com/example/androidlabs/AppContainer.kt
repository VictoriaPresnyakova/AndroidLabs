package com.example.androidlabs

import com.example.androidlabs.DB.repository.HotelRepository
import com.example.androidlabs.DB.repository.OrderRepository
import com.example.androidlabs.DB.repository.UserRepository

interface AppContainer {
    val hotelRepo: HotelRepository
    val userRepo: UserRepository
    val orderRepo: OrderRepository
}