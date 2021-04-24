/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data

import com.kc.android.movies.data.models.ErrorType
import com.kc.android.movies.data.models.Resource
import com.kc.android.movies.data.models.MoviesResponse
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getPopularMovies(): Flow<Resource<MoviesResponse, ErrorType>>
}
