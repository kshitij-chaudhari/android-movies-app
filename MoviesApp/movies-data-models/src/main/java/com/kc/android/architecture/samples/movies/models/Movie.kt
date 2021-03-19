/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.architecture.samples.movies.models

import java.util.Date

data class Movie(
    val id: Int,
        val title: String,
    val releaseDate: Date,
    val popularity: Float,
    val posterImage: String,
    val backdropImage: String
)
