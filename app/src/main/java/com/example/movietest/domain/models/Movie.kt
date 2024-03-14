package com.example.movietest.domain.models

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