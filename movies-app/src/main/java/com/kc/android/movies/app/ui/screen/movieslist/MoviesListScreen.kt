/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.movieslist

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.kc.android.movies.app.Destinations
import com.kc.android.movies.app.ui.common.view.FullScreenCircularLoadingSpinner
import com.kc.android.movies.app.ui.screen.movieslist.views.MovieListItem

@Preview
@Composable
fun MoviesListScreen_Preview() {
    MoviesListScreen()
}

@Composable
fun MoviesListScreen(
    navController: NavController = rememberNavController(),
    moviesListViewModel: MoviesListViewModel = hiltViewModel()
) {

    val movies = moviesListViewModel.movies.collectAsLazyPagingItems()
    val context = LocalContext.current

    if (movies.itemCount == 0) {
        FullScreenCircularLoadingSpinner()
    } else {
        LazyColumn {
            items(movies) { movie ->
                movie?.let {
                    MovieListItem(
                        movie = movie,
                        onclick = {
                            navController.navigate("${Destinations.MovieDetailsScreen.route}/${movie.id}")
                            Toast.makeText(context, movie.title, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}
