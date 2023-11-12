package com.example.androidlabs.DB.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.paging.cachedIn
import com.example.androidlabs.App
import com.example.androidlabs.DB.AppDatabase
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.DB.repository.HotelRepository
import com.example.androidlabs.R

import kotlinx.coroutines.launch

class HotelViewModel(private val hotelRepository: HotelRepository): ViewModel() {
    var name = mutableStateOf("")
    val price = mutableStateOf("")
    val location = mutableStateOf("")
    val stars = mutableStateOf("")
    val info = mutableStateOf("")
    val img = mutableStateOf(R.drawable.img)
    val HotelList = hotelRepository.call().cachedIn(viewModelScope)
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
        hotelRepository.insertHotel(hotel)
    }

    fun deleteHotel(hotel :  Hotel) = viewModelScope.launch {
        hotelRepository.deleteHotel(hotel)
    }

    fun getHotelById(id: Int) = viewModelScope.launch {
        hotelRepository.getHotelById(id)
    }

    fun UpdateHotel(hotel: Hotel) = viewModelScope.launch {
        hotelRepository.updateHotel(hotel)
    }
}