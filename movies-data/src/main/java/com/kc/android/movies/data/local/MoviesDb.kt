/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kc.android.movies.data.models.Movie
import com.kc.android.movies.data.models.RemoteKey

@Database(entities = [Movie::class, RemoteKey::class], version = 1, exportSchema = false)
@TypeConverters(Convertors::class)
abstract class MoviesDb : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
    abstract fun remoteKeyDao(): RemoteKeyDao
}
