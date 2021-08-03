/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.movieslist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.kc.android.movies.domain.interactor.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    application: Application,
    moviesUseCase: MoviesUseCase,
) : AndroidViewModel(application) {

    val movies = moviesUseCase.getMovies(50)
        .cachedIn(viewModelScope)
}
