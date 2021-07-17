/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.di

import com.kc.android.movies.data.remote.CustomGsonConverterFactory
import com.kc.android.movies.data.remote.MoviesService.Companion.BASE_URL
import com.kc.android.movies.data.remote.TmdbOkHttpInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: CustomGsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        tmdbOkHttpInterceptor: TmdbOkHttpInterceptor
    ): OkHttpClient {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addNetworkInterceptor(httpLoggingInterceptor)
            .addInterceptor(tmdbOkHttpInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor()

    @Singleton
    @Provides
    fun provideTmdbOkHttpInterceptor(@Named("tmdb-api-key") tmdbApiKey: String) =
        TmdbOkHttpInterceptor(tmdbApiKey)

    @Singleton
    @Provides
    fun provideGsonConverterFactory() = CustomGsonConverterFactory()
}
