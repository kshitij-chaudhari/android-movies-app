/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKey(@PrimaryKey val label: String, val nextKey: Int?)
