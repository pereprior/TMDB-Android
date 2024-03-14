package com.example.movietest.data.mappers

import com.example.movietest.data.sources.local.room.MovieEntity
import com.example.movietest.domain.models.Movie

class MovieRoomMapper {
    fun entityToModel(movieEntity: MovieEntity): Movie {
        return Movie(
            imageReference = movieEntity.imageReference,
            //genres = it.genres,
            originalLanguage = movieEntity.originalLanguage,
            originalTitle = movieEntity.originalTitle,
            overview = movieEntity.overview,
            posterReference = movieEntity.posterReference,
            releaseDate = movieEntity.releaseDate,
            title = movieEntity.title,
            voteAverage = movieEntity.voteAverage,
            voteCount = movieEntity.voteCount
        )
    }

    fun modelToEntity(movie: Movie): MovieEntity {
        return MovieEntity(
            imageReference = movie.imageReference,
            //genres = movie.genres,
            originalLanguage = movie.originalLanguage,
            originalTitle = movie.originalTitle,
            overview = movie.overview,
            posterReference = movie.posterReference,
            releaseDate = movie.releaseDate,
            title = movie.title,
            voteAverage = movie.voteAverage,
            voteCount = movie.voteCount
        )
    }
}