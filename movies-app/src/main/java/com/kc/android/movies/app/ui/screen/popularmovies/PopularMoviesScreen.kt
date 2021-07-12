/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.popularmovies

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kc.android.movies.app.ui.common.view.FullScreenCircularLoadingSpinner
import com.kc.android.movies.app.ui.screen.popularmovies.views.MovieListItem

@Preview
@Composable
fun PopularMoviesScreen_Preview() {
    PopularMoviesScreen()
}

@Composable
fun PopularMoviesScreen(popularMoviesViewModel: PopularMoviesViewModel = viewModel()) {
    val movies by popularMoviesViewModel.movies.observeAsState(initial = emptyList())
    val loading by popularMoviesViewModel.loading.observeAsState(initial = true)
    val errorMsg by popularMoviesViewModel.errorMsg.observeAsState(initial = null)
    when {
        loading -> {
            FullScreenCircularLoadingSpinner()
        }
        errorMsg != null -> {
            Toast.makeText(LocalContext.current, errorMsg, Toast.LENGTH_SHORT).show()
        }
        else -> {
            LazyColumn {
                items(movies) { movie ->
                    MovieListItem(movie = movie, onclick = { /*TODO*/ })
                    Divider()
                }
            }
        }
    }
}
