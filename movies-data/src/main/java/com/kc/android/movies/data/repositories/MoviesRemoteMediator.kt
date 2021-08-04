/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.kc.android.movies.data.local.MoviesDb
import com.kc.android.movies.data.local.entities.MovieEntity
import com.kc.android.movies.data.local.entities.RemoteKeyEntity
import com.kc.android.movies.data.remote.dtos.mapper.toMovieEntity
import com.kc.android.movies.data.remote.services.MoviesService
import retrofit2.HttpException
import java.io.IOException

private const val REMOTE_KEY_LABEL = "POPULAR_MOVIES_KEY"

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator(private val db: MoviesDb, private val service: MoviesService) :
    RemoteMediator<Int, MovieEntity>() {

    private val moviesDao = db.moviesDao()
    private val remoteKeyDao = db.remoteKeyDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, MovieEntity>): MediatorResult {
        try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val remoteKey = remoteKeyDao.remoteKeyByLabel(REMOTE_KEY_LABEL)
                        ?: return MediatorResult.Success(endOfPaginationReached = true)

                    remoteKey.nextKey
                }
            }
            val response = service.fetchPopularMoviesByPaging(loadKey).body()
                ?: return MediatorResult.Error(IllegalStateException("response is null"))

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    remoteKeyDao.deleteByLabel(REMOTE_KEY_LABEL)
                    moviesDao.deleteAll()
                }
                remoteKeyDao.insertOrReplace(RemoteKeyEntity(REMOTE_KEY_LABEL, response.page + 1))
                moviesDao.insertAll(*response.results.map { it.toMovieEntity() }.toTypedArray())
            }

            return MediatorResult.Success(endOfPaginationReached = response.page >= response.totalPages)
        } catch (ioEx: IOException) {
            return MediatorResult.Error(ioEx)
        } catch (httpEx: HttpException) {
            return MediatorResult.Error(httpEx)
        }
    }
}
