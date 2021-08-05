/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.moviedetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.kc.android.movies.domain.interactor.MoviesUseCase
import com.kc.android.movies.domain.models.Movie
import com.kc.android.movies.domain.models.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    application: Application,
    savedStateHandle: SavedStateHandle,
    moviesUseCase: MoviesUseCase,
) : AndroidViewModel(application) {

    private val movieId: Int = savedStateHandle.get<String>("movieId")?.toInt() ?: 0

    private val _movie: MutableStateFlow<Response<Movie?>> = MutableStateFlow(Response.Loading())
    val movie = _movie.asStateFlow()

    init {
        viewModelScope.launch {
            moviesUseCase.getMovie(movieId).collect {
                delay(750) // delay to demonstrate loading spinner is shown before the actual data loads
                _movie.value = it
            }
        }
    }
}
