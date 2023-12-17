package com.example.androidlabs.api.model

import com.example.androidlabs.DB.models.Hotel
import kotlinx.serialization.Serializable

@Serializable
data class HotelRemote (
    val id: Int? = 0,
    val name: String = "",
    val price: Double = 0.0,
    val img: Int = 0,
    val stars: Int = 0,
    val location: String = "",
    val info: String = "",

    )

fun HotelRemote.toHotel(): Hotel = Hotel(
    id,
    name,
    price,
    img,
    stars,
    location,
    info
)

fun Hotel.toHotelRemote():HotelRemote = HotelRemote(
    hotelId,
    name,
    price,
    img,
    stars,
    location,
    info
)