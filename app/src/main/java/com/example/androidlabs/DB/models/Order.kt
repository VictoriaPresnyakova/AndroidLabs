package com.example.androidlabs.DB.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Order(
    @PrimaryKey(autoGenerate = true)
    val orderId: Int? = null,
    @ColumnInfo(name = "DateFrom")
    val dateFrom: Long,
    @ColumnInfo(name = "DateTo")
    val dateTo: Long,
    @ColumnInfo(name = "Rooms")
    val rooms: Int,
    @ColumnInfo(name = "Total")
    val total: Double,
    @ColumnInfo(name = "CreatorUserId")
    val creatorUserId: Int,
    @ColumnInfo(name = "BookedHotelId")
    val bookedHotelId: Int
)