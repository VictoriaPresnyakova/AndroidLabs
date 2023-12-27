package com.example.androidlabs.businessLogic.repository

import com.example.androidlabs.DB.dao.RemoteKeysDao
import com.example.androidlabs.DB.models.RemoteKeyType
import com.example.androidlabs.DB.models.RemoteKeys

class RemoteKeysRepositoryImpl(private val remoteKeysDao: RemoteKeysDao) : RemoteKeyRepository {
    override suspend fun getAllRemoteKeys(id: Int, type: RemoteKeyType) =
        remoteKeysDao.getRemoteKeys(id, type)

    override suspend fun createRemoteKeys(remoteKeys: List<RemoteKeys>) =
        remoteKeysDao.insertAll(remoteKeys)

    override suspend fun deleteRemoteKey(type: RemoteKeyType) =
        remoteKeysDao.clearRemoteKeys(type)
}