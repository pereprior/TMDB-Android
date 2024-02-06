package com.example.movietest.domain.repositories

import com.example.movietest.data.sources.dto.GenresDTO
import com.example.movietest.data.sources.dto.MovieDTO

interface ILocalDataSource {
    fun getMovieListFromFallback(): MovieDTO
    fun getGenresListFromFallback(): GenresDTO
}