/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kc.android.movies.data.models.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
@TypeConverters(Convertors::class)
abstract class MoviesDb : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}
