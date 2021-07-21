/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.domain.models

import java.util.Date

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val popularity: Float,
    val voteAverage: Float,
    val releaseDate: Date?,
    val posterImagePath: String?,
    val backdropImagePath: String?
)
