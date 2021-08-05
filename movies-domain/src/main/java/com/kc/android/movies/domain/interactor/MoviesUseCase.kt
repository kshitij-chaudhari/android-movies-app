/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.domain.interactor

import androidx.paging.PagingData
import com.kc.android.movies.domain.models.Movie
import com.kc.android.movies.domain.models.Response
import kotlinx.coroutines.flow.Flow

/**
 * UI module should fetch the required data using the exposed Use-Case to ensure Clean Architecture.
 * Also by exposing Interface we ensure that the Impl could be faked during testing.
 */
interface MoviesUseCase {
    /**
     * Fetch paginated list of movies
     */
    fun getMovies(pageSize: Int): Flow<PagingData<Movie>>

    /**
     * Get a single [Movie] by [Movie.id]
     */
    fun getMovie(id: Int): Flow<Response<Movie?>>
}
