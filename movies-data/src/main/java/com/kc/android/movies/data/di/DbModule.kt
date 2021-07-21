/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.di

import android.content.Context
import androidx.room.Room
import com.kc.android.movies.data.local.MoviesDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
    @Singleton
    @Provides
    fun provideMoviesDb(@ApplicationContext context: Context): MoviesDb =
        Room.databaseBuilder(context, MoviesDb::class.java, "movies_db")
            .build()
}
