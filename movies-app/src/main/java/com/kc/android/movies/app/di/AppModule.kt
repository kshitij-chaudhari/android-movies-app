/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.di

import com.kc.android.movies.app.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    @Named("tmdb-api-key")
    fun provideTmdbApiKey() = BuildConfig.TMDB_API_KEY
}
