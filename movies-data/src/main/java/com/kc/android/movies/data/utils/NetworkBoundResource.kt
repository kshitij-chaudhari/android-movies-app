/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.utils

import android.util.Log
import com.kc.android.movies.domain.models.Resource
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
): Flow<Resource<ResultType>> = flow {
    val localData = query().first()

    if (shouldFetch(localData)) {
        emit(Resource.Loading(localData))

        try {
            saveFetchResult(fetch())
            emitAll(query().map { Resource.Success(it) })
        } catch (throwable: Throwable) {
            Log.e(this::class.simpleName, throwable.message, throwable)
            emitAll(query().map { Resource.Error(throwable, it) })
        }
    } else {
        emitAll(query().map { Resource.Success(it) })
    }
}.flowOn(Dispatchers.IO)
