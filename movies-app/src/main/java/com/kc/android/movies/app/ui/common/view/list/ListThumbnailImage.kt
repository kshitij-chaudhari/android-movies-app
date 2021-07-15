/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.common.view.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter

@Preview
@Composable
fun Preview_ListThumbnailImage() {
    ListThumbnailImage(imagePath = "https://www.iceposter.com/thumbs/MOV_f1bd0097_b.jpg")
}

@Composable
fun ListThumbnailImage(imagePath: String) {
    Image(
        contentScale = ContentScale.Crop,
        painter = rememberCoilPainter(
            // TODO use imageLoader + okHttp to pass the api_key
            request = imagePath,
            fadeIn = true
        ),
        modifier = Modifier
            .padding(end = 16.dp)
            .width(90.dp)
            .height(90.dp),
        contentDescription = null
    )
}
