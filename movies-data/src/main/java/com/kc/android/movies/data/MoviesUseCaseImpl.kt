/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data

import androidx.paging.PagingData
import com.kc.android.movies.data.models.Movie
import com.kc.android.movies.data.repo.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesUseCaseImpl @Inject constructor(private val repository: MoviesRepository) : MoviesUseCase {
    override fun getPopularMovies(pageSize: Int): Flow<PagingData<Movie>> = repository.getPopularMovies(pageSize)
}
