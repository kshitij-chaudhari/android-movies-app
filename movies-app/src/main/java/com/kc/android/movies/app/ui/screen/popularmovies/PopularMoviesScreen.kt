/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.popularmovies

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.kc.android.movies.app.ui.screen.popularmovies.views.MovieListItem

@Preview
@Composable
fun PopularMoviesScreen_Preview() {
    PopularMoviesScreen()
}

@Composable
fun PopularMoviesScreen(popularMoviesViewModel: PopularMoviesViewModel = viewModel()) {

    val movies = popularMoviesViewModel.movies.collectAsLazyPagingItems()
    LazyColumn {
        items(movies) { movie ->
            movie?.let {
                MovieListItem(
                    movie = movie,
                    onclick = {
                        // TODO
                    }
                )
                Divider()
            }
        }
    }
}
