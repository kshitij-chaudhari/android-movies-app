/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.popularmovies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.kc.android.movies.data.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    application: Application,
    private val moviesUseCase: MoviesUseCase
) : AndroidViewModel(application) {

    val movies = moviesUseCase.getPopularMovies(50)
        .cachedIn(viewModelScope)
}
