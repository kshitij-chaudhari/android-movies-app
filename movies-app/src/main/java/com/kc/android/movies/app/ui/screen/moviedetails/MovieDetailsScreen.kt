/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.movieslist

import android.widget.Toast
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun MovieDetailsScreen(
    movieId: Int
) {
    val context = LocalContext.current
    Text(text = "TODO")
    Toast.makeText(context, movieId.toString(), Toast.LENGTH_SHORT).show()
}
