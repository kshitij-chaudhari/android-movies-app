/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.moviedetails.views

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kc.android.movies.app.ui.common.view.Image

@Preview
@Composable
fun Preview_ListThumbnailImage() {
    DetailsTopImage(imagePath = "https://www.iceposter.com/thumbs/MOV_f1bd0097_b.jpg")
}

@Composable
fun DetailsTopImage(
    modifier: Modifier = Modifier,
    imagePath: String,
    contentDescription: String? = null
) {
    Image(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.30f),
        imagePath = imagePath,
        contentDescription = contentDescription
    )
}
