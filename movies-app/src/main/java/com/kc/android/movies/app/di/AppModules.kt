/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.di

import com.kc.android.movies.app.BuildConfig
import com.kc.android.movies.data.TmdbConfigurator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModules {
    @Provides
    fun provideTmdbConfigurator(): TmdbConfigurator {
        return TmdbConfigurator(BuildConfig.TMDB_API_KEY)
    }
}
