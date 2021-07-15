/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.repo

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.kc.android.movies.data.local.MoviesDb
import com.kc.android.movies.data.models.Movie
import com.kc.android.movies.data.models.RemoteKey
import com.kc.android.movies.data.remote.MoviesService
import retrofit2.HttpException
import java.io.IOException
import java.lang.IllegalStateException

private const val REMOTE_KEY_LABEL = "POPULAR_MOVIES_KEY"
@ExperimentalPagingApi
class PopularMoviesRemoteMediator(private val db: MoviesDb, private val service: MoviesService) :
    RemoteMediator<Int, Movie>() {

    private val moviesDao = db.moviesDao()
    private val remoteKeyDao = db.remoteKeyDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Movie>): MediatorResult {
        try {
            Log.d(
                PopularMoviesRemoteMediator::class.simpleName,
                """
                PopularMoviesRemoteMediator#load(..) called with arguments -> 
                loadType:$loadType,
                state.pages:${state.pages},
                state.anchorPosition:${state.anchorPosition},
                state.lastItemOrNull:${state.lastItemOrNull()},
                state.config.pageSize:${state.config.pageSize},
                state.config.initialLoadSize:${state.config.initialLoadSize},
                state.config.jumpThreshold:${state.config.jumpThreshold},
                state.config.maxSize:${state.config.maxSize},
                state.config.prefetchDistance:${state.config.prefetchDistance},
                """
            )
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
                remoteKeyDao.insertOrReplace(RemoteKey(REMOTE_KEY_LABEL, response.page + 1))
                moviesDao.insertAll(*response.results.toTypedArray())
            }

            return MediatorResult.Success(endOfPaginationReached = response.page < response.totalPages)
        } catch (ioEx: IOException) {
            return MediatorResult.Error(ioEx)
        } catch (httpEx: HttpException) {
            return MediatorResult.Error(httpEx)
        }
    }
}
