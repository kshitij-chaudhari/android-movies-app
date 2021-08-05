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
import com.kc.android.movies.data.utils.networkBoundResource
import com.kc.android.movies.domain.repositories.MoviesRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val db: MoviesDb,
    private val service: MoviesService
) : MoviesRepository {

    private val moviesDao = db.moviesDao()

    @ExperimentalPagingApi
    override fun getMovies(pageSize: Int) = Pager(
        config = PagingConfig(pageSize),
        remoteMediator = MoviesRemoteMediator(db, service)
    ) {
        moviesDao.pagingSource()
    }.flow.map { pagingData -> pagingData.map { movieEntity -> movieEntity.toMovie() } }

    /**
     * Since movie is previously fetched, currently there is no need to re-fetch movie from network.
     */
    override fun getMovie(id: Int) = networkBoundResource(
        query = { db.moviesDao().get(id) },
        fetch = { /* not needed */ },
        saveFetchResult = { /* not needed */ },
        shouldFetch = { false }
    )
}
