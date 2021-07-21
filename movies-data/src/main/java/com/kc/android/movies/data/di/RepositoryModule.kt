/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.di

import com.kc.android.movies.data.local.MoviesDb
import com.kc.android.movies.data.remote.services.MoviesService
import com.kc.android.movies.data.repositories.MoviesRepositoryImpl
import com.kc.android.movies.domain.repositories.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMoviesRepository(
        db: MoviesDb,
        service: MoviesService
    ): MoviesRepository = MoviesRepositoryImpl(db, service)
}
