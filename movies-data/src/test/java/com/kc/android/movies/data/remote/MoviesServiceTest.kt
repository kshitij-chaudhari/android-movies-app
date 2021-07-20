/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.kc.android.movies.data.fake.FAKE_TMDB_KEY
import com.kc.android.movies.data.fake.FakeMovieResponse
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
class MoviesServiceTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1)
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject lateinit var okHttpClient: OkHttpClient
    @Inject lateinit var gsonConverterFactory: GsonConverterFactory

    private lateinit var mockServer: MockWebServer
    private lateinit var moviesService: MoviesService

    @Before
    fun setUp() {
        hiltRule.inject()

        mockServer = MockWebServer()
        mockServer.start()

        val retrofit = Retrofit.Builder()
            .baseUrl(mockServer.url("/"))
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()

        moviesService = retrofit.create(MoviesService::class.java)
    }

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    @Test
    fun `test-fetchPopularMoviesByPaging-is-returned-and-parsed-properly`() {
        mockServer.enqueue("test-responses/only-black-widow-response.json", 200)

        // TODO can we use [TestCoroutineScope#runBlockingTest] instead of [runBlocking] below? Will need to check how to override okhttp dispatcher to something like [kotlinx.coroutines.test.TestCoroutineDispatcher]
        runBlocking {
            val response = moviesService.fetchPopularMoviesByPaging(1)
            assertThat(response.body()).isEqualTo(FakeMovieResponse.responseWithOnlyBlackWidow)
        }
    }

    @Test
    fun `test-fetchPopularMoviesByPaging-has-correct-path`() {
        mockServer.enqueue("test-responses/only-black-widow-response.json", 200)
        runBlocking {
            moviesService.fetchPopularMoviesByPaging(1)
            assertThat(mockServer.takeRequest().path).isEqualTo("/movie/popular?page=1&api_key=$FAKE_TMDB_KEY")
        }
    }
}
