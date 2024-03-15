package com.example.movietest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movietest.data.db.entities.MovieEntity

@Dao
interface MovieDAO {
    // Mostrar todos los campos de la db
    @Query("SELECT * FROM movies_table")
    suspend fun getFavoriteMovies(): List<MovieEntity>

    // Añadir un campo a la db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    // Eliminar un campo de la db
    @Query("DELETE FROM movies_table WHERE original_title = :title")
    suspend fun removeMovie(title: String)

    // Eliminar
}