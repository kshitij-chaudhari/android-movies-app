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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.kc.android.movies.app.BuildConfig
import com.kc.android.movies.app.ui.common.view.FullScreenCircularLoadingSpinner
import com.kc.android.movies.app.ui.common.view.HeaderText
import com.kc.android.movies.app.ui.screen.moviedetails.views.DetailsTopImage
import com.kc.android.movies.domain.models.Movie
import com.kc.android.movies.domain.models.Response

@Composable
fun MovieDetailsScreen(
    movieDetailsViewModel: MovieDetailsViewModel = hiltViewModel()
) {
    // Flow needs to be collected using [Flow#flowWithLifecycle] to ensure that producer is cancelled when the
    // app moves in background.
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleAwareFlow = remember(movieDetailsViewModel.movie, lifecycleOwner) {
        movieDetailsViewModel.movie.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }
    val response by lifecycleAwareFlow.collectAsState(Response.Loading())
    when (response) {
        is Response.Success<Movie?> -> {
            val movie = (response as Response.Success<Movie?>).data
            // Future Improvement - Currently nothing is done when [Movie] is null. Could be represented in a better way.
            movie?.let {
                Column {
                    DetailsTopImage(imagePath = "https://image.tmdb.org/t/p/w342${movie.backdropImagePath ?: movie.posterImagePath}?api_key=${BuildConfig.TMDB_API_KEY}")

                    // Note: below could be moved out to custom composables, but not done in the sample
                    Spacer(modifier = Modifier.height(16.dp))
                    HeaderText(text = movie.title, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = movie.overview, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
                }
            }
        }
        else -> {
            FullScreenCircularLoadingSpinner()
        }
    }
}
