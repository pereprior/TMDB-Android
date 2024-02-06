package com.example.movietest.domain.repositories

import com.example.movietest.data.sources.dto.GenresDTO
import com.example.movietest.data.sources.dto.MovieDTO

interface IRemoteDataSource {
    suspend fun getMovieListFromApi(): MovieDTO
    suspend fun getGenresListFromApi(): GenresDTO
}