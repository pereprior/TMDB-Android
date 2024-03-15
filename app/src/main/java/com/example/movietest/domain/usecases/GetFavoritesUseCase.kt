package com.example.movietest.domain.usecases

import com.example.movietest.data.MovieRepository
import com.example.movietest.domain.models.Movie
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend fun execute(): List<Movie> {
        return repository.getFavoritesList()
    }

    suspend fun insert(movie: Movie) {
        repository.addFavorite(movie)
    }

    suspend fun delete(movie: Movie) {
        repository.removeFavorite(movie)
    }
}