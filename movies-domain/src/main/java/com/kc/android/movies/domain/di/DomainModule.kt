/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.domain.di

import com.kc.android.movies.domain.interactor.MoviesUseCase
import com.kc.android.movies.domain.interactor.MoviesUseCaseImpl
import com.kc.android.movies.domain.repositories.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    /**
     * Default provider for [MoviesUseCase] so UI module need not worry about it.
     */
    @Singleton
    @Provides
    fun provideMoviesUseCase(repository: MoviesRepository): MoviesUseCase = MoviesUseCaseImpl(repository)
}
