package com.example.movietest.domain.repositories

import com.example.movietest.domain.models.Movie

interface IMovieRepository {
    suspend fun getMovieList(): List<Movie>
}