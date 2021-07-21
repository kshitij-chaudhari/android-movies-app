/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.di

import android.content.Context
import androidx.room.Room
import com.kc.android.movies.data.local.MoviesDb
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DbModule::class]
)
object TestDBModule {
    @Singleton
    @Provides
    fun provideMoviesDb(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context, MoviesDb::class.java)
            .allowMainThreadQueries()
            .build()
}
