/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.popularmovies.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SynopsisText() {
    SynopsisText(text = "desc")
}

@Composable
fun SynopsisText(text: String) {
    Text(text = text, maxLines = 4, overflow = TextOverflow.Ellipsis)
}
