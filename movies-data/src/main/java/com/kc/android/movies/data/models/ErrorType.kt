/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.models

sealed class ErrorType {
    data class NetworkError(val responseCode: Int) : ErrorType()
    data class Unknown(val message: String) : ErrorType()
}
