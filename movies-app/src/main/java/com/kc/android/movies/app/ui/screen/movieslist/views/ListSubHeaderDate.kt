/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.movieslist.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

private const val DATE_FORMAT = "dd MMM, yyyy"

@Preview
@Composable
fun Preview_ListSubHeaderDate() {
    ListSubHeaderDate(date = Calendar.getInstance().time)
}

@Composable
fun ListSubHeaderDate(date: Date?) {
    Text(
        text = date?.let {
            SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(date)
        } ?: ""
    )
}
