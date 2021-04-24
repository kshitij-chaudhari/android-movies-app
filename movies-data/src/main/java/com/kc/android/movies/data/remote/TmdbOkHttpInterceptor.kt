/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote

import com.kc.android.movies.data.TmdbConfigurator
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class TmdbOkHttpInterceptor(private val tmdbConfigurator: TmdbConfigurator) : Interceptor {
    override fun intercept(chain: Chain): Response {
        val httpUrl = chain.request().url().newBuilder()
            .addQueryParameter("api_key", tmdbConfigurator.apiKey)
            .build()

        val modifiedRequest = chain.request().newBuilder()
            .url(httpUrl).build()

        return chain.proceed(modifiedRequest)
    }
}
