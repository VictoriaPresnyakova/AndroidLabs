package com.example.androidlabs.api.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.DB.models.Order

import kotlinx.serialization.Serializable

@Serializable
data class OrderRemote(
    val id: Int? = 0,
    val dateFrom: String = "",
    val dateTo: String = "",
    val rooms: Int = 0,
    val total: Double = 0.0,
    val userId: Int = 0,
    val bookedHotelId: Int = 0
    )

fun OrderRemote.toOrder(): Order = Order(
    id,
    dateFrom,
    dateTo,
    rooms,
    total,
    userId,
    bookedHotelId,
    )

fun Order.toOrderRemote():OrderRemote = OrderRemote(
    orderId,
    dateFrom,
    dateTo,
    rooms,
    total,
    creatorUserId,
    bookedHotelId,
)