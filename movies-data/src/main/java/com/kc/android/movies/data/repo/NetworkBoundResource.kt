/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.repo

import android.util.Log
import com.kc.android.movies.data.models.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {
    val localData = query().first()

    val flow = if (shouldFetch(localData)) {
        emit(Resource.Loading(localData))

        try {
            saveFetchResult(fetch())
            // TODO - handle returning error case when fetch fails
            query().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            Log.e(this::class.simpleName, throwable.message, throwable)
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        query().map { Resource.Success(it) }
    }
    emitAll(flow)
}.flowOn(Dispatchers.IO)
