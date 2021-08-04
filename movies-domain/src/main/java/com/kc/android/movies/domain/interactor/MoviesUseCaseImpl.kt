/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.domain.interactor

import androidx.paging.PagingData
import com.kc.android.movies.domain.models.Movie
import com.kc.android.movies.domain.models.Response
import com.kc.android.movies.domain.repositories.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesUseCaseImpl @Inject constructor(private val repository: MoviesRepository) : MoviesUseCase {
    override fun getMovies(pageSize: Int): Flow<PagingData<Movie>> = repository.getMovies(pageSize)
    override fun getMovie(id: Int): Flow<Response<Movie>> = repository.getMovie(id)
}
