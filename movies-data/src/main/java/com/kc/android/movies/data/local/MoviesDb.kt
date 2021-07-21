/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kc.android.movies.data.local.daos.MoviesDao
import com.kc.android.movies.data.local.daos.RemoteKeyDao
import com.kc.android.movies.data.local.entities.MovieEntity
import com.kc.android.movies.data.local.entities.RemoteKeyEntity

@Database(entities = [MovieEntity::class, RemoteKeyEntity::class], version = 1, exportSchema = false)
@TypeConverters(DbConvertors::class)
abstract class MoviesDb : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
    abstract fun remoteKeyDao(): RemoteKeyDao
}
