/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.domain.repositories

import androidx.paging.PagingData
import com.kc.android.movies.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMovies(pageSize: Int): Flow<PagingData<Movie>>
}
