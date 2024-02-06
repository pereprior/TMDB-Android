package com.example.movietest.domain.usecases

import com.example.movietest.data.repositories.MovieRepositoryImpl
import com.example.movietest.domain.models.Movie
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val repository: MovieRepositoryImpl
) {
    // Funcion que utiliza el view model para obtener los datos de las peliculas
    suspend fun execute(): List<Movie> {
        return repository.getMovieList()
    }
}