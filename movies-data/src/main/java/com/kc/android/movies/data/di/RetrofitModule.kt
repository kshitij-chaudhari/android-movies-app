/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.di

import com.kc.android.movies.data.TmdbConfigurator
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

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

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

    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor()

    @Provides
    fun provideTmdbOkHttpInterceptor(tmdbConfigurator: TmdbConfigurator = TmdbConfigurator()) =
        TmdbOkHttpInterceptor(tmdbConfigurator)

    @Provides
    fun provideGsonConverterFactory() = CustomGsonConverterFactory()
}
