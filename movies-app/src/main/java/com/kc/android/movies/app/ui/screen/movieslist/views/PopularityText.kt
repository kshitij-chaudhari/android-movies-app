/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.movieslist.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kc.android.movies.app.R

@Preview
@Composable
fun Preview_PopularityText() {
    PopularityText(score = 7.8f)
}

@Composable
fun PopularityText(score: Float) = Text(text = stringResource(R.string.label_popularity, score))
