package com.example.movietest.data.repositories

import com.example.movietest.data.mappers.MovieRoomMapper
import com.example.movietest.data.sources.local.room.MovieDAO
import com.example.movietest.data.sources.local.room.MovieEntity
import com.example.movietest.domain.models.Movie
import com.example.movietest.domain.repositories.IMovieRepository

class MovieRoomRepository(
    private val movieDAO: MovieDAO
): IMovieRepository {
    val mapper: MovieRoomMapper
        get() {
            TODO()
        }

    override suspend fun getMovieList(): List<Movie> {
        val entities = movieDAO.getFavoriteMovies()

        return entities.map {
            mapper.entityToModel(it)
        }
    }

    suspend fun insertMovie(movie: Movie) {
        movieDAO.insertMovie(mapper.modelToEntity(movie))
    }

    suspend fun removeMovie(movie: Movie) {
        movieDAO.removeMovie(mapper.modelToEntity(movie).id!!)
    }
}