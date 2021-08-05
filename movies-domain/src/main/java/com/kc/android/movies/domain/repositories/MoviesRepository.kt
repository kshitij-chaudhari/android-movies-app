/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.domain.repositories

import androidx.paging.PagingData
import com.kc.android.movies.domain.models.Movie
import com.kc.android.movies.domain.models.Response
import kotlinx.coroutines.flow.Flow

/**
 * UseCase class delegates the actual work of fetching the required data to repository.
 * This class is expected to decide from what source(s) it needs to get the required the data.
 */
interface MoviesRepository {
    fun getMovies(pageSize: Int): Flow<PagingData<Movie>>
    fun getMovie(id: Int): Flow<Response<Movie?>>
}
