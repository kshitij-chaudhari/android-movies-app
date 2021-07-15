/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data

import androidx.paging.PagingData
import com.kc.android.movies.data.models.Movie
import kotlinx.coroutines.flow.Flow

// TODO investigate is movies-data can be converted to java-library
interface MoviesUseCase {
    fun getPopularMovies(pageSize: Int): Flow<PagingData<Movie>>
}
