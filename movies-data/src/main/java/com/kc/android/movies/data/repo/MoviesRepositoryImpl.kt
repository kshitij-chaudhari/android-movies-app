/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.kc.android.movies.data.local.MoviesDb
import com.kc.android.movies.data.remote.MoviesService
import javax.inject.Inject

// TODO make internal along with other impls in the module
class MoviesRepositoryImpl @Inject constructor(
    private val db: MoviesDb,
    private val service: MoviesService
) : MoviesRepository {

    private val moviesDao = db.moviesDao()

    @ExperimentalPagingApi
    override fun getPopularMovies(pageSize: Int) = Pager(
        config = PagingConfig(pageSize),
        remoteMediator = PopularMoviesRemoteMediator(db, service)
    ) {
        moviesDao.pagingSource()
    }.flow
}
