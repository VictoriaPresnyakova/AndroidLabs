package com.example.androidlabs

import RestUserRepository
import android.content.Context
import com.example.androidlabs.DB.AppDatabase
import com.example.androidlabs.businessLogic.repository.HotelRepImpl
import com.example.androidlabs.businessLogic.repository.HotelRepository
import com.example.androidlabs.businessLogic.repository.OrderRepository
import com.example.androidlabs.businessLogic.repository.RemoteKeysRepositoryImpl
import com.example.androidlabs.businessLogic.repository.UserRepository
import com.example.androidlabs.api.BackendService
import com.example.androidlabs.api.repository.RestHotelRepository
import com.example.androidlabs.api.repository.RestOrderRepository


class AppDataContainer(private val context: Context) : AppContainer {
    override val hotelRepo: HotelRepository by lazy {
        RestHotelRepository(
            BackendService.getInstance(),
            hotelRepository,
            AppDatabase.getInstance(context),
            remoteKeyRepository
        )
    }
    override val userRepo: UserRepository by lazy {
        RestUserRepository(BackendService.getInstance())
    }

    override val orderRepo: OrderRepository by lazy {
        RestOrderRepository(BackendService.getInstance())
    }
    private val hotelRepository: HotelRepImpl by lazy {
        HotelRepImpl(AppDatabase.getInstance(context).hotelDao())
    }
    private val remoteKeyRepository: RemoteKeysRepositoryImpl by lazy {
        RemoteKeysRepositoryImpl(AppDatabase.getInstance(context).remoteKeysDao())
    }
}