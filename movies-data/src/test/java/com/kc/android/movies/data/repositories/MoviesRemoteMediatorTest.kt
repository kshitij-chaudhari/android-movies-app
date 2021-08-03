/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingConfig
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.kc.android.movies.data.fake.FakeMovieResponse
import com.kc.android.movies.data.local.MoviesDb
import com.kc.android.movies.data.local.entities.MovieEntity
import com.kc.android.movies.data.remote.services.MoviesService
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import retrofit2.Response
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalPagingApi::class, ExperimentalCoroutinesApi::class)
class MoviesRemoteMediatorTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject lateinit var db: MoviesDb
    @RelaxedMockK lateinit var moviesService: MoviesService
    private lateinit var remoteMediator: MoviesRemoteMediator

    private val testScope = TestCoroutineScope()

    @Before
    fun setUp() {
        hiltRule.inject()
        MockKAnnotations.init(this)
        remoteMediator = MoviesRemoteMediator(db, moviesService)
    }

    @After
    fun tearDown() {
        db.clearAllTables()
        clearAllMocks()
    }

    @Test
    // TODO Ignored since getting stuck on runBlockingTest. Need to investigate
    @Ignore(value = "Reason mentioned in TODO above.")
    fun `test-LoadType-REFRESH-returns-MediatorResult-Success-with-endOfPaginationReached-false`() = testScope.runBlockingTest {
        coEvery { moviesService.fetchPopularMoviesByPaging(any()) } returns
            Response.success(FakeMovieResponse.responseWithOnlyBlackWidow)

        val pagingState = PagingState<Int, MovieEntity>(
            pages = emptyList(),
            anchorPosition = null,
            config = PagingConfig(pageSize = 1),
            leadingPlaceholderCount = 0
        )
        val result = remoteMediator.load(LoadType.REFRESH, pagingState)

        assertThat(result).isInstanceOf(RemoteMediator.MediatorResult.Success::class.java)
        assertThat((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached).isFalse()
    }
}
