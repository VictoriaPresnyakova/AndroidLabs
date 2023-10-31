package com.example.androidlabs.DB.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.androidlabs.App
import com.example.androidlabs.DB.AppDatabase
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.R

import kotlinx.coroutines.launch

class HotelViewModel(val database: AppDatabase): ViewModel() {
    var name = mutableStateOf("")
    val price = mutableStateOf("")
    val location = mutableStateOf("")
    val stars = mutableStateOf("")
    val info = mutableStateOf("")
    val img = mutableStateOf(R.drawable.img)
    val HotelList = database.hotelDao().getAllHotelss()
    var hotel: Hotel? = null

    fun insertHotel() = viewModelScope.launch {
        val hotel = Hotel(
            name = name.value,
            location = location.value,
            price = price.value.toDouble(),
            img = img.value,
            stars = stars.value.toInt(),
            info = info.value
        )
        database.hotelDao().insert(hotel)
    }

    fun deleteHotel(hotel :  Hotel) = viewModelScope.launch {
        database.hotelDao().delete(hotel)
    }

    fun getHotelById(id: Int) = viewModelScope.launch {
        database.hotelDao().getHotelById(id)
    }

    fun UpdateHotel(hotel: Hotel) = viewModelScope.launch {
        database.hotelDao().update(hotel)
    }

    companion object{
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return HotelViewModel(database) as T
            }
        }
    }
}