/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.repo

import androidx.paging.PagingData
import com.kc.android.movies.data.models.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getPopularMovies(pageSize: Int): Flow<PagingData<Movie>>
}
