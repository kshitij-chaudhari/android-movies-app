/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * Note: Same Movie class re-used for both DB and DTO. In a more commercial application we might want
 * to separate them to remove dependency.
 */
@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey val id: Int,
    @SerializedName("title") val
    title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("release_date") val releaseDate: Date,
    @SerializedName("poster_path") val posterImagePath: String?,
    @SerializedName("backdrop_path") val backdropImagePath: String?
)
