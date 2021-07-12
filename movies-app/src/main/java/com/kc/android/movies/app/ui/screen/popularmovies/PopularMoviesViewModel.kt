/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.app.ui.screen.popularmovies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kc.android.movies.app.R
import com.kc.android.movies.app.ui.MoviesApp
import com.kc.android.movies.data.MoviesUseCase
import com.kc.android.movies.data.models.Movie
import com.kc.android.movies.data.models.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    application: Application,
    private val moviesUseCase: MoviesUseCase
) :
    AndroidViewModel(application) {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading
    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String>
        get() = _errorMsg

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            moviesUseCase.fetchPopularMovies()
                .collect {
                    when (it) {
                        is Resource.Loading -> _loading.value = true
                        is Resource.Success -> {
                            _loading.value = false
                            _movies.value = it.data
                        }
                        is Resource.Error -> {
                            _loading.value = false
                            _errorMsg.value = getApplication<MoviesApp>().getString(
                                R.string.error_msg_unknown_error,
                                it.error.message
                            )
                        }
                    }
                }
        }
    }
}
