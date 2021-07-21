/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.fake

import com.kc.android.movies.data.local.entities.MovieEntity
import java.text.SimpleDateFormat
import java.util.Locale

object FakeMovieEntities {
    val blackWidow = MovieEntity(
        id = 497698,
        title = "Black Widow",
        overview = "Natasha Romanoff, also known as Black Widow, confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger.",
        popularity = 11579.322f,
        voteAverage = 8.1f,
        releaseDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse("2021-07-07"),
        posterImagePath = "/qAZ0pzat24kLdO3o8ejmbLxyOac.jpg",
        backdropImagePath = "/gX5UrH1TLVVBwI7WxplW43BD6Z1.jpg"
    )

    val luca = MovieEntity(
        id = 508943,
        title = "Luca",
        overview = "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
        popularity = 4375.44f,
        voteAverage = 8.1f,
        releaseDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse("2021-06-17"),
        posterImagePath = "/jTswp6KyDYKtvC52GbHagrZbGvD.jpg",
        backdropImagePath = "/xXHZeb1yhJvnSHPzZDqee0zfMb6.jpg"
    )
}
