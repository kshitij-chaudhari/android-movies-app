/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.models

import java.util.Date

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val popularity: Float,
    val releaseDate: Date,
    val posterImage: String,
    val backdropImage: String
)
