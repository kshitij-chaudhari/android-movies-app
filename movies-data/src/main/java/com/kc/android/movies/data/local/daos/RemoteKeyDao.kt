/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kc.android.movies.data.local.entities.RemoteKeyEntity

@Dao
interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(remoteKeyEntity: RemoteKeyEntity)

    @Query("SELECT * FROM remote_keys WHERE label = :label")
    suspend fun remoteKeyByLabel(label: String): RemoteKeyEntity?

    @Query("DELETE FROM remote_keys WHERE label = :label")
    suspend fun deleteByLabel(label: String)
}
