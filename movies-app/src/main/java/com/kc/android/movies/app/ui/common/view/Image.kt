/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.common.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.coil.rememberCoilPainter

@Preview
@Composable
fun Preview_Image() {
    Image(imagePath = "https://www.iceposter.com/thumbs/MOV_f1bd0097_b.jpg")
}

@Composable
fun Image(
    modifier: Modifier = Modifier,
    imagePath: String,
    contentDescription: String? = null
) {
    Image(
        contentScale = ContentScale.Crop,
        painter = rememberCoilPainter(
            request = imagePath,
            fadeIn = true
        ),
        modifier = modifier,
        contentDescription = contentDescription
    )
}
