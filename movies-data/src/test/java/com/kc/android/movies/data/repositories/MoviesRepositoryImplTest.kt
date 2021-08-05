/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.ExperimentalPagingApi
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.kc.android.movies.data.fake.FakeMovieEntities
import com.kc.android.movies.data.fake.FakeMovies
import com.kc.android.movies.data.local.MoviesDb
import com.kc.android.movies.data.remote.services.MoviesService
import com.kc.android.movies.domain.models.Response
import com.kc.android.movies.domain.repositories.MoviesRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import io.mockk.Called
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalPagingApi::class, ExperimentalCoroutinesApi::class)
class MoviesRepositoryImplTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject lateinit var db: MoviesDb
    @RelaxedMockK lateinit var moviesService: MoviesService

    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun setUp() {
        hiltRule.inject()
        MockKAnnotations.init(this)
        moviesRepository = MoviesRepositoryImpl(db, moviesService)
    }

    @After
    fun tearDown() {
        db.clearAllTables()
        clearAllMocks()
    }

    @Test
    fun `test-getMovie-fetches-data-from-db`() = runBlocking {
        db.moviesDao().insertAll(FakeMovieEntities.luca)

        val response = moviesRepository.getMovie(FakeMovieEntities.luca.id).first()

        Truth.assertThat(response).isInstanceOf(Response.Success::class.java)
        Truth.assertThat((response as Response.Success).data).isEqualTo(FakeMovies.luca)
    }

    @Test
    fun `test-getMovie-does-not-fetch-from-network`() = runBlocking {
        moviesRepository.getMovie(FakeMovieEntities.luca.id)

        verify { moviesService wasNot Called }
    }
}
