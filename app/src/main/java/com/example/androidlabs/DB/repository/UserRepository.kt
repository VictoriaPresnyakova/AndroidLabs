package com.example.androidlabs.DB.repository

import com.example.androidlabs.DB.models.User

interface UserRepository {
    suspend fun createUser(user: User)
    suspend fun updateUser(user: User)
    suspend fun deleteUser(user: User)
    suspend fun getUserById(id: Int): User
    suspend fun getUserByEmail(email: String): User
}