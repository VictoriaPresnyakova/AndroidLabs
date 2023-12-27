package com.example.androidlabs.businessLogic.repository

import com.example.androidlabs.DB.models.RemoteKeyType
import com.example.androidlabs.DB.models.RemoteKeys

interface RemoteKeyRepository {
    suspend fun getAllRemoteKeys(id: Int, type: RemoteKeyType): RemoteKeys?
    suspend fun createRemoteKeys(remoteKeys: List<RemoteKeys>)
    suspend fun deleteRemoteKey(type: RemoteKeyType)
}