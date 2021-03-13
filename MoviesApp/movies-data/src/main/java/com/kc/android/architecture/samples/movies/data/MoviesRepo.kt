package com.kc.android.architecture.samples.movies.data

import com.kc.android.architecture.samples.movies.models.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepo {
    fun getPopular(): Flow<Set<Movie>>
}
