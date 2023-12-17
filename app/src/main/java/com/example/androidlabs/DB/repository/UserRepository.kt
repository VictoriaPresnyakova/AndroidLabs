package com.example.androidlabs.DB.repository

import com.example.androidlabs.DB.models.User
import com.example.androidlabs.api.model.UserRemoteSignIn

interface UserRepository {
    suspend fun createUser(user: User)
    suspend fun updateUser(user: User)
    suspend fun deleteUser(user: User)
    suspend fun authUser(user: UserRemoteSignIn): User
}