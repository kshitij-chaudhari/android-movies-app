/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.fake

import com.kc.android.movies.data.models.MoviesResponse

object FakeMovieResponse {
    val responseWithOnlyBlackWidow = MoviesResponse(
        page = 1,
        results = listOf(FakeMovies.blackWidow),
        totalPages = 2,
        totalResults = 2
    )
}
