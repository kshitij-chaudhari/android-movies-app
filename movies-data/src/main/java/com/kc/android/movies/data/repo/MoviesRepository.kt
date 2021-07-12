/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.repo

import com.kc.android.movies.data.models.Movie
import com.kc.android.movies.data.models.Resource
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getPopularMovies(): Flow<Resource<List<Movie>>>
}
