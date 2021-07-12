/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.di

import android.content.Context
import androidx.room.Room
import com.kc.android.movies.data.MoviesUseCase
import com.kc.android.movies.data.MoviesUseCaseImpl
import com.kc.android.movies.data.local.MoviesDb
import com.kc.android.movies.data.remote.MoviesService
import com.kc.android.movies.data.repo.MoviesRepository
import com.kc.android.movies.data.repo.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DataModules {
    @Provides
    fun provideMoviesUseCase(repository: MoviesRepository): MoviesUseCase =
        MoviesUseCaseImpl(repository)

    @Provides
    fun provideMoviesRepository(db: MoviesDb, service: MoviesService): MoviesRepository =
        MoviesRepositoryImpl(db, service)

    @Provides
    fun provideMoviesService(retrofit: Retrofit): MoviesService =
        retrofit.create(MoviesService::class.java)

    @Provides
    fun provideMoviesDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MoviesDb::class.java, "movies_db")
            .build()
}
