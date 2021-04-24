/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote

import com.kc.android.movies.data.models.ErrorType
import com.kc.android.movies.data.models.Resource
import com.kc.android.movies.data.models.MoviesResponse

interface MoviesRemoteDataSource {
    suspend fun fetchPopularMovies(): Resource<MoviesResponse, ErrorType>
}
