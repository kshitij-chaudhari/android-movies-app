/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.kc.android.movies.app.ui.screen.popularmovies.PopularMoviesScreen
import com.kc.android.movies.app.ui.theme.MoviesAppTheme

@Composable
fun MoviesAppScreen() {
    MoviesAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            PopularMoviesScreen()
        }
    }
}
