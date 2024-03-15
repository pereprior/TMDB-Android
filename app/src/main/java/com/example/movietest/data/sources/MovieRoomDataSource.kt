package com.example.movietest.data.sources

import com.example.movietest.data.db.dao.MovieDAO
import com.example.movietest.data.db.entities.MovieEntity

class MovieRoomDataSource(
    private val movieDAO: MovieDAO
) {
    // Obtenemos la lista de peliculas favoritas de la db
    suspend fun getFavoriteMoviesFromDatabase(): List<MovieEntity> {
        return movieDAO.getFavoriteMovies()
    }

    // Añadimos una pelicula a la db
    suspend fun insertMovieOnDatabase(movie: MovieEntity) {
        movieDAO.insertMovie(movie)
    }

    // Eliminamos una pelicula de la db
    suspend fun removeMovieOnDatabase(title: String) {
        movieDAO.removeMovie(title)
    }
}