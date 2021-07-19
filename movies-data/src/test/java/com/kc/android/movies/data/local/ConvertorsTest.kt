/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.local

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ConvertorsTest {
    lateinit var convertors: Convertors

    @Before
    fun setUp() {
        convertors = Convertors()
    }

    @Test
    fun `test-date-to-timestamp`() {
        val actualTimestamp = convertors.dateToTimestamp(TestData.date)
        Truth.assertThat(actualTimestamp).isEqualTo(TestData.timestamp)
    }

    @Test
    fun timestampToDate() {
        val actualDate = convertors.timestampToDate(TestData.timestamp)
        Truth.assertThat(actualDate).isEqualTo(TestData.date)
    }
}

private object TestData {
    val date: Date = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).parse("2021-01-01")!!
    val timestamp = date.time
}
