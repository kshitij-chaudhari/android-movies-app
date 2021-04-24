/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.kc.android.movies.app.ui.screen.popularmovies.PopularMoviesScreen
import com.kc.android.movies.app.ui.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                PopularMoviesScreen()
            }
        }
    }
}
