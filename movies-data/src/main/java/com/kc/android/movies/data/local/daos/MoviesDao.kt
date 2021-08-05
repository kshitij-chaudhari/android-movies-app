/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.local.daos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kc.android.movies.data.local.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies WHERE id = :movieId")
    fun get(movieId: Int): Flow<MovieEntity>

    @Query("SELECT * FROM movies")
    fun getAll(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies ORDER BY popularity DESC")
    fun pagingSource(): PagingSource<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg movieEntity: MovieEntity)

    @Query("DELETE FROM movies")
    suspend fun deleteAll()
}
