/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val overview: String,
    val popularity: Float,
    val voteAverage: Float,
    val releaseDate: Date?,
    val posterImagePath: String?,
    val backdropImagePath: String?
)
