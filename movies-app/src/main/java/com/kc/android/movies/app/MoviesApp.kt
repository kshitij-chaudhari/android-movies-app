/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * [Application] class is extended to initialise [HiltAndroidApp]
 */
@HiltAndroidApp
class MoviesApp : Application()
