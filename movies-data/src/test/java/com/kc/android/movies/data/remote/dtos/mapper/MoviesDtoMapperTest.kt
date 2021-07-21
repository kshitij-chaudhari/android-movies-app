/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote.dtos.mapper

import com.google.common.truth.Truth.assertThat
import com.kc.android.movies.data.fake.FakeMovieDtos
import com.kc.android.movies.data.fake.FakeMovieEntities
import com.kc.android.movies.data.fake.FakeMovies
import org.junit.Test

class MoviesDtoMapperTest {

    @Test
    fun `test-MovieDto-to-Movie-mapping`() {
        val expectedMovie = FakeMovies.blackWidow
        val movieEntityUnderTest = FakeMovieDtos.blackWidow
        assertThat(movieEntityUnderTest.toMovie()).isEqualTo(expectedMovie)
    }

    @Test
    fun `test-MovieDto-to-MovieEntity-mapping`() {
        val expectedMovie = FakeMovieEntities.blackWidow
        val movieEntityUnderTest = FakeMovieDtos.blackWidow
        assertThat(movieEntityUnderTest.toMovieEntity()).isEqualTo(expectedMovie)
    }
}
