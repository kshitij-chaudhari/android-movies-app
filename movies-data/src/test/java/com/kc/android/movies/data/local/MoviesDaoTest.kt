/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingSource
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.kc.android.movies.data.fake.FakeMovieEntities
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import javax.inject.Inject

/**
 * Annotated with [HiltAndroidTest] to inject module [com.kc.android.movies.data.di.TestDBModule].
 * Alternatively, we can annotate with [UninstallModules] to selectively uninstall a specific module
 */
@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalCoroutinesApi::class)
class MoviesDaoTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var db: MoviesDb

    // Reason for using [TestCoroutineScope] is well explained here - https://tinyurl.com/evp6842w
    private val testScope = TestCoroutineScope()

    @Before
    fun setUp() = hiltRule.inject()

    @After
    fun tearDown() {
        testScope.cleanupTestCoroutines()
        db.clearAllTables()
    }

    @Test
    fun `test-insert-all-and-get-all`() = testScope.runBlockingTest {
        db.moviesDao().insertAll(FakeMovieEntities.blackWidow)

        val fetchedMovies = db.moviesDao().getAll().first()
        assertThat(fetchedMovies).containsExactly(FakeMovieEntities.blackWidow)
    }

    @Test
    fun `test-delete-all`() = testScope.runBlockingTest {
        db.moviesDao().insertAll(FakeMovieEntities.blackWidow, FakeMovieEntities.luca)

        db.moviesDao().deleteAll()
        assertThat(db.moviesDao().getAll().first()).isEmpty()
    }

    @Test
    fun `test-paging-source-returns-same-as-page-size`() {
        // TODO could this be runBlockingTest?
        runBlocking {
            val moviesList = listOf(FakeMovieEntities.blackWidow, FakeMovieEntities.luca)
            db.moviesDao().insertAll(*moviesList.toTypedArray())

            val expected = PagingSource.LoadResult.Page(
                data = listOf(FakeMovieEntities.blackWidow),
                prevKey = null,
                nextKey = 1
            )

            val resultPagingSource = db.moviesDao().pagingSource()
            val actual = resultPagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 1,
                    placeholdersEnabled = false
                )
            )

            // check if only FakeMovies.blackWidow is returned
            assertThat((actual as PagingSource.LoadResult.Page).data).isEqualTo(expected.data)
        }
    }
}
