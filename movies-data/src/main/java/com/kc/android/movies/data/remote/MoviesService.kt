/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote

import com.kc.android.movies.data.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface MoviesService {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("movie/popular")
    suspend fun fetchPopularMovies(): Response<MoviesResponse>
}
