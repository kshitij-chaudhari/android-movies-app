/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.popularmovies.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kc.android.movies.app.BuildConfig
import com.kc.android.movies.data.models.Movie
import java.util.Date

@Preview("MovieListItem Preview")
@Composable
fun Preview_MovieListItem() {
    val movie = Movie(
        id = 0,
        title = "Raya and the Last Dragon",
        overview = "In a realm known as Kumandra, " +
            "a re-imagined Earth inhabited by " +
            "an ancient civilization, a warrior " +
            "named Raya is determined to find " +
            "the last dragon.",
        popularity = 0f,
        voteAverage = 7.8f,
        releaseDate = Date(),
        posterImagePath = "",
        backdropImagePath = ""
    )
    MovieListItem(movie = movie, onclick = {})
}

@Composable
fun MovieListItem(movie: Movie, onclick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = onclick)
            .padding(16.dp)
    ) {
        ThumbnailImage("https://image.tmdb.org/t/p/w342" + movie.posterImagePath + "?api_key=" + BuildConfig.TMDB_API_KEY)
        Column {
            TitleText(movie.title)
            RatingText(rating = movie.voteAverage)
            SynopsisText(text = movie.overview)
        }
    }
}
