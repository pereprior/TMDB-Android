package com.example.movietest.data.mappers

import com.example.movietest.data.sources.dto.GenresDTO
import com.example.movietest.data.sources.dto.MovieDTO
import com.example.movietest.domain.models.Movie

// Clase que convierte el DTO en el modelo que maneja la ui
class MovieGsonDataMapper(
    private val movieDTO: MovieDTO,
    private val genresDTO: GenresDTO
) {
    fun convert(): List<Movie> {
        val movies = ArrayList<Movie>()

        // Buscamos los generos de la pelicula por su id en la lista de generos
        movieDTO.results.map { movieResult ->
            val movieGenres = movieResult.genreIds.mapNotNull { genreId ->
                genresDTO.genres.find { it.id == genreId }?.name
            }

            movies.add(
                Movie(
                    imageReference = movieResult.backdropPath,
                    //genres = movieGenres,
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
}
