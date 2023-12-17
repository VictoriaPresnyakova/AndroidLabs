package com.example.androidlabs.api.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

import com.example.androidlabs.DB.models.User
import com.example.androidlabs.DB.models.RoleEnum

import kotlinx.serialization.Serializable

@Serializable
data class UserRemote (
    val id: Int? = 0,
    val name: String = "",
    val surname: String = "",
    val email: String = "",
    val password: String = "",
    val role: String = "",
    val photo: Int? = 0,
)


fun UserRemote.toUser(): User = User(
    id,
    name,
    surname,
    email,
    password,
    role,
    photo
)

fun User.toUserRemote():UserRemote = UserRemote(
    userId,
    name,
    surname,
    email,
    password,
    role,
    photo
)