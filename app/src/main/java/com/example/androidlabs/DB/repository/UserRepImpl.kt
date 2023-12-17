package com.example.androidlabs.DB.repository

import com.example.androidlabs.DB.dao.UserDao
import com.example.androidlabs.DB.models.User

//class UserRepImpl(private val userDao: UserDao) : UserRepository {
//
//    override suspend fun createUser(user: User) = userDao.createUser(user)
//
//    override suspend fun updateUser(user: User) = userDao.updateUser(user)
//
//    override suspend fun deleteUser(user: User) = userDao.deleteUser(user)
//
//    override suspend fun getUserById(id: Int): User = userDao.getUserById(id)
//
//    override suspend fun getUserByEmail(email: String): User = userDao.getUserByEmail(email)
//}