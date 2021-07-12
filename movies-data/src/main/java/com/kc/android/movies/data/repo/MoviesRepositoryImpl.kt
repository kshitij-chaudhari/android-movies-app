/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.repo

import com.kc.android.movies.data.local.MoviesDb
import com.kc.android.movies.data.remote.MoviesService
import kotlinx.coroutines.delay
import javax.inject.Inject

// TODO make internal along with other impls in the module
class MoviesRepositoryImpl @Inject constructor(
    private val db: MoviesDb,
    private val service: MoviesService
) : MoviesRepository {

    private val moviesDao = db.moviesDao()
    override fun getPopularMovies() = networkBoundResource(
        query = {
            moviesDao.getAll()
        },
        fetch = {
            delay(1000)
            service.fetchPopularMovies()
        },
        saveFetchResult = { result ->
            result.body()?.results?.toTypedArray()?.let {
                moviesDao.insertAll(*it)
            }
        },
        shouldFetch = {
            it.isEmpty()
        }
    )
}
