/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.moviedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kc.android.movies.app.BuildConfig
import com.kc.android.movies.app.ui.common.view.FullScreenCircularLoadingSpinner
import com.kc.android.movies.app.ui.common.view.HeaderText
import com.kc.android.movies.app.ui.screen.moviedetails.views.DetailsTopImage
import com.kc.android.movies.domain.models.Movie
import com.kc.android.movies.domain.models.Resource

@Composable
fun MovieDetailsScreen(
    movieDetailsViewModel: MovieDetailsViewModel = viewModel()
) {
    val state = movieDetailsViewModel.movie.collectAsState(initial = Resource.Loading())
    when (state.value) {
        is Resource.Success<Movie> -> {
            val movie = (state.value as Resource.Success<Movie>).data
            Column {
                DetailsTopImage(imagePath = "https://image.tmdb.org/t/p/w342${movie.backdropImagePath ?: movie.posterImagePath}?api_key=${BuildConfig.TMDB_API_KEY}")

                // Note: below could be moved out to custom composables, but not done in the sample
                Spacer(modifier = Modifier.height(16.dp))
                HeaderText(text = movie.title, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = movie.overview, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
            }
        }
        else -> {
            FullScreenCircularLoadingSpinner()
        }
    }
}
