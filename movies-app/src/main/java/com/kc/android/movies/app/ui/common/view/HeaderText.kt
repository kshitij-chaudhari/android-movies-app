/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.common.view

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Preview_HeaderText() {
    HeaderText(text = "Avengers: Infinity War")
}

@Preview
@Composable
fun Preview_HeaderText_Long() {
    HeaderText(
        text = "Avengers: Infinity War. This is a very long title " +
            "that is expected to overflow. But since it is not overflowing, I will keep adding text here."
    )
}

@Composable
fun HeaderText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text, fontWeight = FontWeight.Bold,
        modifier = modifier,
        maxLines = 2, overflow = TextOverflow.Ellipsis,
        color = MaterialTheme.colors.primary
    )
}
