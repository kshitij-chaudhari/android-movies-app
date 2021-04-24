/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data

import javax.inject.Inject

class MoviesUseCaseImpl @Inject constructor(private val repository: MoviesRepository) : MoviesUseCase {
    override fun fetchPopularMovies() = repository.getPopularMovies()
}
