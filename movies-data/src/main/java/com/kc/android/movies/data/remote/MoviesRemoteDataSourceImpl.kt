/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote

import com.kc.android.movies.data.models.ErrorType
import com.kc.android.movies.data.models.Resource
import com.kc.android.movies.data.models.MoviesResponse
import javax.inject.Inject

class MoviesRemoteDataSourceImpl @Inject constructor(private val moviesService: MoviesService) : MoviesRemoteDataSource {
    override suspend fun fetchPopularMovies(): Resource<MoviesResponse, ErrorType> {
        val response = moviesService.fetchPopularMovies()
        if(response.isSuccessful && response.body()!=null) {
            return Resource.Success(response.body()!!)
        }

        return Resource.Error(ErrorType.Unknown(response.code()))
    }
}
