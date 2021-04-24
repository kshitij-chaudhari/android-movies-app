/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.popularmovies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview
@Composable
fun PopularMoviesScreen_Preview() {
    PopularMoviesScreen()
}

@Composable
fun PopularMoviesScreen(popularMoviesViewModel: PopularMoviesViewModel = viewModel()) {
    val movies by popularMoviesViewModel.movies.observeAsState()
    LazyColumn {
        items(movies ?: emptyList()) { movie ->
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable(onClick = ({}))
            ) {
                Text(text = movie.overview)
            }
            Divider()
        }
    }
}
