/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val popularity: Float,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("release_date") val releaseDate: Date,
    @SerializedName("poster_path") val posterImagePath: String,
    @SerializedName("backdrop_path") val backdropImagePath: String
)
