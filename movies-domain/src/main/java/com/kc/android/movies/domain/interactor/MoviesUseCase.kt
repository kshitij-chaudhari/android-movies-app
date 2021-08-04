/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.domain.interactor

import androidx.paging.PagingData
import com.kc.android.movies.domain.models.Movie
import com.kc.android.movies.domain.models.Response
import kotlinx.coroutines.flow.Flow

interface MoviesUseCase {
    /**
     * Fetch paginated list of movies
     */
    fun getMovies(pageSize: Int): Flow<PagingData<Movie>>

    /**
     * Get a single [Movie] by [Movie.id]
     */
    fun getMovie(id: Int): Flow<Response<Movie>>
}
