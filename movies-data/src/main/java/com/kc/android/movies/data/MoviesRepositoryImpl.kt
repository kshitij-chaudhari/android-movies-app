/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data

import com.kc.android.movies.data.models.ErrorType
import com.kc.android.movies.data.remote.MoviesRemoteDataSource
import com.kc.android.movies.data.models.Movie
import com.kc.android.movies.data.models.MoviesResponse
import com.kc.android.movies.data.models.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

// TODO make internal along with other impls in the module
class MoviesRepositoryImpl @Inject constructor(private val service: MoviesRemoteDataSource) :
    MoviesRepository {
    override fun getPopularMovies(): Flow<Resource<MoviesResponse, ErrorType>> = flow {
        emit(Resource.Loading)
        delay(1 * 1000) // 1 sec
        emit(service.fetchPopularMovies())
    }.flowOn(Dispatchers.IO)
}
