package com.kc.android.movies.app.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.size.Scale
import coil.size.Scale.FIT
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.kc.android.movies.app.BuildConfig
import com.kc.android.movies.data.models.Movie
import java.util.*

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
        Image(
            contentScale = ContentScale.Crop,
            painter = rememberCoilPainter(
                //TODO use imageLoader + okHttp to pass the api_key
                request = "https://image.tmdb.org/t/p/w342" + movie.posterImagePath + "?api_key="+ BuildConfig.TMDB_API_KEY,
//                requestBuilder = {
//                    scale(FIT)
//                },
//                imageLoader = imageLoader,
                fadeIn = true,
//                previewPlaceholder = previewPlaceholder,
//                shouldRefetchOnSizeChange = shouldRefetchOnSizeChange,
            ),
            modifier = Modifier
                .padding(end = 16.dp)
                .width(112.dp)
                .height(160.dp),
            contentDescription = null
        )
        Column {
            Text(text = movie.title, fontWeight = FontWeight.Bold)
            Text(text = movie.overview, maxLines = 7, overflow = TextOverflow.Ellipsis)
        }
    }
}