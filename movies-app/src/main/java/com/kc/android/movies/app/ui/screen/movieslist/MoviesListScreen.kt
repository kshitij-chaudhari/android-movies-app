/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.movieslist

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.kc.android.movies.app.ui.screen.movieslist.views.MovieListItem

@Preview
@Composable
fun MoviesListScreen_Preview() {
    MoviesListScreen()
}

@Composable
fun MoviesListScreen(moviesViewModel: MoviesViewModel = viewModel()) {

    val movies = moviesViewModel.movies.collectAsLazyPagingItems()
    val context = LocalContext.current
    LazyColumn {
        items(movies) { movie ->
            movie?.let {
                MovieListItem(
                    movie = movie,
                    onclick = {
                        Toast.makeText(context, movie.title, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}
