/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.di

import com.kc.android.movies.data.MoviesRepository
import com.kc.android.movies.data.MoviesRepositoryImpl
import com.kc.android.movies.data.MoviesUseCase
import com.kc.android.movies.data.MoviesUseCaseImpl
import com.kc.android.movies.data.remote.MoviesRemoteDataSource
import com.kc.android.movies.data.remote.MoviesRemoteDataSourceImpl
import com.kc.android.movies.data.remote.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DataModules {
    @Provides
    fun provideMoviesUseCase(repository: MoviesRepository): MoviesUseCase =
        MoviesUseCaseImpl(repository)

    @Provides
    fun provideMoviesRepository(remoteDataSource: MoviesRemoteDataSource): MoviesRepository =
        MoviesRepositoryImpl(remoteDataSource)

    @Provides
    fun provideMoviesRemoteDataSource(moviesService: MoviesService): MoviesRemoteDataSource =
        MoviesRemoteDataSourceImpl(moviesService)

    @Provides
    fun provideMoviesService(retrofit: Retrofit): MoviesService =
        retrofit.create(MoviesService::class.java)
}
