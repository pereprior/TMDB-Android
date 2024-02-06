package com.example.movietest.data.repositories

import com.example.movietest.data.mappers.MovieDataMapper
import com.example.movietest.data.sources.dto.GenresDTO
import com.example.movietest.data.sources.dto.MovieDTO
import com.example.movietest.data.sources.local.MovieJsonDataSource
import com.example.movietest.data.sources.remote.MovieRemoteDataSource
import com.example.movietest.domain.models.Movie
import com.example.movietest.domain.repositories.IMovieRepository

class MovieRepositoryImpl (
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieJsonDataSource
): IMovieRepository {
    override suspend fun getMovieList(): List<Movie> {
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

        return MovieDataMapper(movies, genres).convert()
    }
}