/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.kc.android.movies.app.ui.theme.AppTheme

/**
 * The main [App] Composable is the entry point for all Composables.
 * It sets the [AppTheme] and [NavGraph] which sets the application flow.
 */
@Composable
fun App() {
    AppTheme {
        Surface(color = MaterialTheme.colors.background) {
            val navController = rememberNavController()
            NavGraph(navController)
        }
    }
}
