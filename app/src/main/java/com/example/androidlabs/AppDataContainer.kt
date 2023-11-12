package com.example.androidlabs

import android.content.Context
import com.example.androidlabs.DB.AppDatabase
import com.example.androidlabs.DB.repository.HotelRepImpl
import com.example.androidlabs.DB.repository.HotelRepository
import com.example.androidlabs.DB.repository.OrderRepImpl
import com.example.androidlabs.DB.repository.OrderRepository
import com.example.androidlabs.DB.repository.UserRepImpl
import com.example.androidlabs.DB.repository.UserRepository

class AppDataContainer(private val context: Context) : AppContainer {
    override val hotelRepo: HotelRepository by lazy {
        HotelRepImpl(AppDatabase.getInstance(context).hotelDao())
    }
    override val userRepo: UserRepository by lazy {
        UserRepImpl(AppDatabase.getInstance(context).userDao())
    }
    override val orderRepo: OrderRepository by lazy {
        OrderRepImpl(AppDatabase.getInstance(context).orderDao())
    }
}