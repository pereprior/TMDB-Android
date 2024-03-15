package com.example.movietest.data

import com.example.movietest.data.api.dto.GenresDTO
import com.example.movietest.data.api.dto.MovieDTO
import com.example.movietest.data.api.dto.toDomain
import com.example.movietest.data.db.entities.toDomain
import com.example.movietest.data.sources.MovieFallbackDataSource
import com.example.movietest.data.sources.MovieRemoteDataSource
import com.example.movietest.data.sources.MovieRoomDataSource
import com.example.movietest.domain.models.Movie
import com.example.movietest.domain.models.toDatabase

class MovieRepository (
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieFallbackDataSource,
    private val roomDataSource: MovieRoomDataSource
) {
    suspend fun getMovieList(): List<Movie> {
        var movies: MovieDTO
        var genres: GenresDTO

        // Si no se puede acceder a la api, cargamos el fichero como fallback
        try {
            genres = remoteDataSource.getGenresListFromApi()
            movies = remoteDataSource.getMovieListFromApi()
        } catch (e: Exception) {
            genres = localDataSource.getGenresListFromFallback()
            movies = localDataSource.getMovieListFromFallback()
        }

        return movies.toDomain(genres)
    }

    suspend fun getFavoritesList(): List<Movie> {
        val favoritesDAO = roomDataSource.getFavoriteMoviesFromDatabase()
        // Devolvemos la lista de todas las pelis favoritas
        return favoritesDAO.map { it.toDomain() }
    }

    suspend fun addFavorite(movie: Movie) {
        roomDataSource.insertMovieOnDatabase(movie.toDatabase())
    }

    suspend fun removeFavorite(movie: Movie) {
        roomDataSource.removeMovieOnDatabase(movie.originalTitle)
    }
}