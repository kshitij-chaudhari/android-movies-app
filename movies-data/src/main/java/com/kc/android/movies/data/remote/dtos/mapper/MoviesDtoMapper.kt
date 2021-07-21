/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote.dtos.mapper

import com.kc.android.movies.data.local.entities.MovieEntity
import com.kc.android.movies.data.remote.dtos.MovieDto
import com.kc.android.movies.domain.models.Movie

fun MovieDto.toMovie() = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    popularity = this.popularity,
    voteAverage = this.voteAverage,
    releaseDate = this.releaseDate,
    posterImagePath = this.posterImagePath,
    backdropImagePath = this.backdropImagePath
)

fun MovieDto.toMovieEntity() = MovieEntity(
    id = this.id,
    title = this.title,
    overview = this.overview,
    popularity = this.popularity,
    voteAverage = this.voteAverage,
    releaseDate = this.releaseDate,
    posterImagePath = this.posterImagePath,
    backdropImagePath = this.backdropImagePath
)
