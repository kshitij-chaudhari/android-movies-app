/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data

import com.kc.android.movies.models.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesManager {
    fun getPopular(): Flow<Set<Movie>>
}