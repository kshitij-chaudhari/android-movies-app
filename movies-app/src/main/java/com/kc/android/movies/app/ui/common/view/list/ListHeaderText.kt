/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.common.view.list

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Preview_ListHeaderText() {
    ListHeaderText(text = "Avengers: Infinity War")
}

@Preview
@Composable
fun Preview_ListHeaderText_Long() {
    ListHeaderText(
        text = "Avengers: Infinity War. This is a very long title " +
            "that is expected to overflow. But since it is not overflowing, I will keep adding text here."
    )
}

@Composable
fun ListHeaderText(text: String) {
    Text(
        text = text, fontWeight = FontWeight.Bold,
        maxLines = 2, overflow = TextOverflow.Ellipsis,
        color = MaterialTheme.colors.primary
    )
}
