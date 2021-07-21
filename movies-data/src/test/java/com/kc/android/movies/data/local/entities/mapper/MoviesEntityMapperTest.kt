/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.local.entities.mapper

import com.google.common.truth.Truth.assertThat
import com.kc.android.movies.data.fake.FakeMovieEntities
import com.kc.android.movies.data.fake.FakeMovies
import org.junit.Test

class MoviesEntityMapperTest {

    @Test
    fun `test-MovieEntity-to-Movie-mapping`() {
        val expectedMovie = FakeMovies.blackWidow
        val movieEntityUnderTest = FakeMovieEntities.blackWidow
        assertThat(movieEntityUnderTest.toMovie()).isEqualTo(expectedMovie)
    }
}
