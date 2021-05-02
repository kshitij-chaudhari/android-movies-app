/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.popularmovies

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kc.android.movies.app.ui.view.MovieListItem

@Preview
@Composable
fun PopularMoviesScreen_Preview() {
    PopularMoviesScreen()
}

@Composable
fun PopularMoviesScreen(popularMoviesViewModel: PopularMoviesViewModel = viewModel()) {
    val movies by popularMoviesViewModel.movies.observeAsState()
    LazyColumn {
        items(movies ?:  emptyList()) { movie ->
            MovieListItem(movie = movie, onclick = {/*TODO*/})
            Divider()
        }
    }
}
