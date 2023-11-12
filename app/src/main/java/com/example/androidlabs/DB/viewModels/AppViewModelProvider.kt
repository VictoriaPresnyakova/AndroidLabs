package com.example.androidlabs.DB.viewModels

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.androidlabs.App

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HotelViewModel(app().container.hotelRepo)
        }
        initializer {
            UserViewModel(app().container.userRepo)
        }
        initializer {
            OrderViewModel(app().container.orderRepo)
        }
    }
}

fun CreationExtras.app(): App =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as App)