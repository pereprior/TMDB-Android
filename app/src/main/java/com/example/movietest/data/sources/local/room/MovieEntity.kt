package com.example.movietest.data.sources.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

// Clase de pelicula que maneja la base de datos
@Entity
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val imageReference: String,
    //val genres: List<String>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterReference: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int
)