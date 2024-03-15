package com.example.movietest.domain.models

import com.example.movietest.data.db.entities.MovieEntity

// Clase de pelicula que maneja la ui
data class Movie(
    val imageReference: String,
    val genres: List<String> = emptyList(),
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterReference: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int,
    var favorite: Boolean = false
)

fun Movie.toDatabase(): MovieEntity {
    return MovieEntity(
        imageReference = imageReference,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        posterReference = posterReference,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}