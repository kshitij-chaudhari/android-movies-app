/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import java.lang.IllegalStateException
import java.nio.charset.StandardCharsets

/**
 * Reference - https://tinyurl.com/yknxbrnk
 */
internal fun MockWebServer.enqueue(responseJsonPath: String, code: Int) {
    javaClass.classLoader?.getResourceAsStream(responseJsonPath)?.use {
        val source = it.source().buffer()
        enqueue(
            MockResponse()
                .setBody(source.readString(StandardCharsets.UTF_8))
                .setResponseCode(code)
        )
    } ?: throw IllegalStateException("Not able to read file $responseJsonPath")
}
