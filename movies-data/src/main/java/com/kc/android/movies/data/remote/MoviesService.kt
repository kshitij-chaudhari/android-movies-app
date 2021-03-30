/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote

import com.kc.android.movies.models.Movie

interface MoviesService {
    suspend fun fetchPopularMovies(): List<Movie>
}
