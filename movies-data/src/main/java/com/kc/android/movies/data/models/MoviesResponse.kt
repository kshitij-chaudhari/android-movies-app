package com.kc.android.movies.data.models

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val page: Int,
    @SerializedName("results") val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)