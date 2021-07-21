/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.local.entities.mapper

import com.kc.android.movies.data.local.entities.MovieEntity
import com.kc.android.movies.domain.models.Movie

fun MovieEntity.toMovie() = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    popularity = this.popularity,
    voteAverage = this.voteAverage,
    releaseDate = this.releaseDate,
    posterImagePath = this.posterImagePath,
    backdropImagePath = this.backdropImagePath
)
