/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.di

import com.kc.android.movies.data.MoviesUseCase
import com.kc.android.movies.data.MoviesUseCaseImpl
import com.kc.android.movies.data.local.MoviesDb
import com.kc.android.movies.data.remote.MoviesService
import com.kc.android.movies.data.repo.MoviesRepository
import com.kc.android.movies.data.repo.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModules {
    @Singleton
    @Provides
    fun provideMoviesUseCase(repository: MoviesRepository): MoviesUseCase =
        MoviesUseCaseImpl(repository)

    @Singleton
    @Provides
    fun provideMoviesRepository(db: MoviesDb, service: MoviesService): MoviesRepository =
        MoviesRepositoryImpl(db, service)

    @Singleton
    @Provides
    fun provideMoviesService(retrofit: Retrofit): MoviesService =
        retrofit.create(MoviesService::class.java)
}
