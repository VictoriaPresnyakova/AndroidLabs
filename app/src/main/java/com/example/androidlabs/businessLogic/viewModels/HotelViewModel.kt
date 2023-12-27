package com.example.androidlabs.businessLogic.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.businessLogic.repository.HotelRepository
import com.example.androidlabs.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch

class HotelViewModel(private val hotelRepository: HotelRepository): MyViewModel() {
    var name = mutableStateOf("")
    val price = mutableStateOf("")
    val location = mutableStateOf("")
    val stars = mutableStateOf("")
    val info = mutableStateOf("")
    val img = mutableStateOf(R.drawable.img)
    var hotel: Hotel? = null

    private val _hotelList = MutableStateFlow(hotelRepository.getAllHotels())
    val hotelList: StateFlow<Flow<PagingData<Hotel>>> get() = _hotelList

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
        runInScope(
            actionSuccess = {
                hotelRepository.deleteHotel(hotel)
            }
        )
    }

    fun getHotelById(id: Int) = viewModelScope.launch {
        hotelRepository.getHotelById(id)
    }

    fun searchHotelsByFilter(filter: String) {
        viewModelScope.launch {
            val filteredHotels = hotelRepository.search(filter).cachedIn(viewModelScope)
            _hotelList.value = filteredHotels
        }
    }

    fun UpdateHotel(hotel: Hotel) = viewModelScope.launch {
        hotelRepository.updateHotel(hotel)
    }
}