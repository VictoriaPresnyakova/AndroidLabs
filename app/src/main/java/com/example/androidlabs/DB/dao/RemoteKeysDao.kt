package com.example.androidlabs.DB.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidlabs.DB.models.RemoteKeyType
import com.example.androidlabs.DB.models.RemoteKeys


@Dao
interface RemoteKeysDao {
    @Query("SELECT * FROM remote_keys WHERE entityId = :entityId AND type = :type")
    suspend fun getRemoteKeys(entityId: Int, type: RemoteKeyType): RemoteKeys?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeys>)
    @Query("DELETE FROM remote_keys WHERE type = :type")
    suspend fun clearRemoteKeys(type: RemoteKeyType)
}