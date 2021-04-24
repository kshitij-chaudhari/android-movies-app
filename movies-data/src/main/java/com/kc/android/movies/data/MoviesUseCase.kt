/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data

import com.kc.android.movies.data.models.ErrorType
import com.kc.android.movies.data.models.MoviesResponse
import com.kc.android.movies.data.models.Resource
import kotlinx.coroutines.flow.Flow

// TODO investigate is movies-data can be converted to java-library
interface MoviesUseCase {
    fun fetchPopularMovies(): Flow<Resource<MoviesResponse, ErrorType>>
}
