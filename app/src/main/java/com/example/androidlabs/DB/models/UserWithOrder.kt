package com.example.androidlabs.DB.models

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithOrder(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "CreatorUserId"
    )
    val orders: List<Order>
)