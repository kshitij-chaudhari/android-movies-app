/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kc.android.movies.app.ui.screen.movieslist.MovieDetailsScreen
import com.kc.android.movies.app.ui.screen.movieslist.MoviesListScreen
import com.kc.android.movies.app.ui.screen.movieslist.MoviesViewModel

/**
 * All the possible routes are defined inside [Destinations].
 * This should be used elsewhere from the application to navigate to destinations.
 */
sealed class Destinations(val route: String) {
    object MoviesListScreen : Destinations("movies-list-screen-route")
    object MovieDetailsScreen : Destinations("movie-details-screen-route")
}

/**
 * This composable acts as the Navigation Graph for the entire app.
 */
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.MoviesListScreen.route
    ) {
        composable(Destinations.MoviesListScreen.route) {
            val moviesViewModel = hiltViewModel<MoviesViewModel>()
            MoviesListScreen(navController, moviesViewModel)
        }
        composable("${Destinations.MovieDetailsScreen.route}/{movieId}") { backStackEntry ->
            MovieDetailsScreen(
                movieId = backStackEntry.arguments?.getInt("movieId")!!
            )
        }
    }
}
