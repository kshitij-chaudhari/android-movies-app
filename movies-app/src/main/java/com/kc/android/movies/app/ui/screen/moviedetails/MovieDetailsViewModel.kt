/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.moviedetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import com.kc.android.movies.domain.interactor.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    application: Application,
    savedStateHandle: SavedStateHandle,
    moviesUseCase: MoviesUseCase,
) : AndroidViewModel(application) {

    private val movieId: Int = savedStateHandle.get<String>("movieId")!!.toInt()

    val movie = moviesUseCase.getMovie(movieId)
}
