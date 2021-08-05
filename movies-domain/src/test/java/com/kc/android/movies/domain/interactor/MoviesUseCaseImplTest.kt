/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.domain.interactor

import com.kc.android.movies.domain.repositories.MoviesRepository
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class MoviesUseCaseImplTest {

    @RelaxedMockK lateinit var repository: MoviesRepository

    @Before fun setUp() = MockKAnnotations.init(this)
    @After fun tearDown() = clearAllMocks()

    @Test
    fun `getMovies-calls-repository-with-given-pageSize`() {
        val moviesUseCase = MoviesUseCaseImpl(repository)
        val pageSize = 10

        moviesUseCase.getMovies(pageSize)
        verify { repository.getMovies(pageSize) }
    }

    @Test
    fun `getMovie-calls-repository-with-given-movieIf`() {
        val moviesUseCase = MoviesUseCaseImpl(repository)
        val movieId = 1

        moviesUseCase.getMovie(movieId)
        verify { repository.getMovie(movieId) }
    }
}
