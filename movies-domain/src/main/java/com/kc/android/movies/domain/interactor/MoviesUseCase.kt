/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.domain.interactor

import androidx.paging.PagingData
import com.kc.android.movies.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesUseCase {
    fun getMovies(pageSize: Int): Flow<PagingData<Movie>>
}
