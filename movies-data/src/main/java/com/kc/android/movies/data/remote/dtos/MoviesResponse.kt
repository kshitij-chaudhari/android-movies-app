/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val page: Int,
    @SerializedName("results") val results: List<MovieDto>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)
