/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.models

sealed class Resource<out DATA> {
    data class Loading<out DATA>(val data: DATA? = null) : Resource<DATA>()
    data class Success<out DATA>(val data: DATA) : Resource<DATA>()
    data class Error<out DATA>(val error: Throwable, val data: DATA? = null) : Resource<DATA>()
}
