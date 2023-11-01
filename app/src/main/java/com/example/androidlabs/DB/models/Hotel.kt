package com.example.androidlabs.DB.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hotel (
    @PrimaryKey(autoGenerate = true)
    val hotelId: Int? = null,

    @ColumnInfo(name = "Name")
    val name: String,

    @ColumnInfo(name = "Price")//
    val price: Double,

    @ColumnInfo(name = "Img")//
    val img: Int,

    @ColumnInfo(name = "Stars")//
    val stars: Int,

    @ColumnInfo(name = "Location")//
    val location: String,

    @ColumnInfo(name = "Info")//
    val info: String,
)