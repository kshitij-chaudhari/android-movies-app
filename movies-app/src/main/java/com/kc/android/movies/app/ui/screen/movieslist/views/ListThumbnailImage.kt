/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.movieslist.views

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kc.android.movies.app.ui.common.view.Image

@Preview
@Composable
fun Preview_ListThumbnailImage() {
    ListThumbnailImage(imagePath = "https://www.iceposter.com/thumbs/MOV_f1bd0097_b.jpg")
}

@Composable
fun ListThumbnailImage(
    modifier: Modifier = Modifier,
    imagePath: String,
    contentDescription: String? = null
) {
    Image(
        modifier = modifier
            .padding(end = 16.dp)
            .width(90.dp)
            .height(90.dp),
        imagePath = imagePath,
        contentDescription = contentDescription
    )
}
