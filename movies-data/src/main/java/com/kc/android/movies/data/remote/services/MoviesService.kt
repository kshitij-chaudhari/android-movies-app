/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote.services

import com.kc.android.movies.data.remote.dtos.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesService {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("movie/popular")
    suspend fun fetchPopularMoviesByPaging(@Query("page") page: Int?): Response<MoviesResponse>
}
