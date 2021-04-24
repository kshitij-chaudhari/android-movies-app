/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.models

sealed class ErrorType {
    data class Unknown(val responseCode: Int) : ErrorType()
}
