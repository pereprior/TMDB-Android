package com.example.movietest.data.api.dto

import com.example.movietest.domain.models.Movie
import com.google.gson.annotations.SerializedName

// Clase que guarda los datos de la api/json
data class MovieDTO(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<Result>,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int
)

fun MovieDTO.toDomain(genresDTO: GenresDTO): List<Movie> {
    val movies = ArrayList<Movie>()

    // Buscamos los generos de la pelicula por su id en la lista de generos
    this.results.map { movieResult ->
        val movieGenres = movieResult.genreIds.mapNotNull { genreId ->
            genresDTO.genres.find { it.id == genreId }?.name
        }

        movies.add(
            Movie(
                imageReference = movieResult.backdropPath,
                genres = movieGenres,
                originalLanguage = movieResult.originalLanguage,
                originalTitle = movieResult.originalTitle,
                overview = movieResult.overview,
                posterReference = movieResult.posterPath,
                releaseDate = movieResult.releaseDate,
                title = movieResult.title,
                voteAverage = movieResult.voteAverage,
                voteCount = movieResult.voteCount
            )
        )
    }

    return movies
}