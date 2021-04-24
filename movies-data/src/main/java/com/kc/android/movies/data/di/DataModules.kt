/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.di

import com.kc.android.movies.data.*
import com.kc.android.movies.data.remote.MoviesRemoteDataSource
import com.kc.android.movies.data.remote.MoviesRemoteDataSourceImpl
import com.kc.android.movies.data.remote.MoviesService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class DataModules {
    @Provides
    fun provideMoviesUseCase(repository: MoviesRepository) : MoviesUseCase
        = MoviesUseCaseImpl(repository)

    @Provides
    fun provideMoviesRepository(remoteDataSource: MoviesRemoteDataSource): MoviesRepository
        = MoviesRepositoryImpl(remoteDataSource)

    @Provides
    fun provideMoviesRemoteDataSource(moviesService: MoviesService): MoviesRemoteDataSource
        = MoviesRemoteDataSourceImpl(moviesService)

    @Provides
    fun provideMoviesService(retrofit: Retrofit) : MoviesService
        = retrofit.create(MoviesService::class.java)
}