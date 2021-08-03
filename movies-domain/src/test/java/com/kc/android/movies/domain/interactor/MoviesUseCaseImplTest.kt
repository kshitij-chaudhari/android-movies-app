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
    fun `getPopularMovies-passes-pageSize-to-repository`() {
        val moviesUseCase = MoviesUseCaseImpl(repository)
        val pageSize = 10

        moviesUseCase.getMovies(pageSize)
        verify { repository.getMovies(pageSize) }
    }
}
