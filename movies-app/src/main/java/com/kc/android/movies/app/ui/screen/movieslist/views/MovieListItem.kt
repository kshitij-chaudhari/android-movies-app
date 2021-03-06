/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.movieslist.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kc.android.movies.app.BuildConfig
import com.kc.android.movies.app.ui.common.view.HeaderText
import com.kc.android.movies.domain.models.Movie
import java.util.Date

@Preview("MovieListItem Preview")
@Composable
fun Preview_MovieListItem() {
    val movie = Movie(
        id = 0,
        title = "Avengers: Infinity War",
        overview = "The Avengers and their allies must be willing to " +
            "sacrifice all in an attempt to defeat the powerful " +
            "Thanos before his blitz of devastation and ruin " +
            "puts an end to the universe.",
        popularity = 2001.5f,
        voteAverage = 8.4f,
        releaseDate = Date(),
        posterImagePath = "",
        backdropImagePath = ""
    )
    MovieListItem(movie = movie, onclick = {})
}

@Composable
fun MovieListItem(
    movie: Movie,
    onclick: (Movie) -> Unit,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    color: Color = MaterialTheme.colors.surface,
    shape: Shape = RoundedCornerShape(8.dp),
) {
    Surface(
        elevation = elevation,
        color = color,
        modifier = modifier.padding(16.dp, 8.dp, 16.dp, 8.dp),
        shape = shape
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onclick(movie) })
                .padding(16.dp)
        ) {
            ListThumbnailImage(imagePath = "https://image.tmdb.org/t/p/w342${movie.posterImagePath ?: ""}?api_key=${BuildConfig.TMDB_API_KEY}")
            Column {
                HeaderText(movie.title)
                ListSubHeaderDate(movie.releaseDate)
                PopularityText(movie.popularity)
            }
        }
    }
}
