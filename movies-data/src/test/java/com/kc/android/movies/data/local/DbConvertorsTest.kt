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

class DbConvertorsTest {
    lateinit var dbConvertors: DbConvertors

    @Before
    fun setUp() {
        dbConvertors = DbConvertors()
    }

    @Test
    fun `test-date-to-timestamp`() {
        val actualTimestamp = dbConvertors.dateToTimestamp(TestData.date)
        Truth.assertThat(actualTimestamp).isEqualTo(TestData.timestamp)
    }

    @Test
    fun `test-timestamp-to-date`() {
        val actualDate = dbConvertors.timestampToDate(TestData.timestamp)
        Truth.assertThat(actualDate).isEqualTo(TestData.date)
    }
}

private object TestData {
    val date: Date = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).parse("2021-01-01")!!
    val timestamp = date.time
}
