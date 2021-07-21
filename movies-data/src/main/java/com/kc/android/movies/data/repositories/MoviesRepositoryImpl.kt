/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.kc.android.movies.data.local.MoviesDb
import com.kc.android.movies.data.local.entities.mapper.toMovie
import com.kc.android.movies.data.remote.services.MoviesService
import com.kc.android.movies.domain.repositories.MoviesRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

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
    }.flow.map { pagingData -> pagingData.map { movieEntity -> movieEntity.toMovie() } }
}
