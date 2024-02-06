package com.example.movietest.data.sources.remote

import com.example.movietest.data.sources.dto.GenresDTO
import com.example.movietest.data.sources.dto.MovieDTO
import com.example.movietest.domain.repositories.IRemoteDataSource

class MovieRemoteDataSource (
    private val api: IApiService
): IRemoteDataSource {
    // Obtenemos la lista de peliculas de la api
    override suspend fun getMovieListFromApi(): MovieDTO {
        return api.getMovieList()
    }

    // Obtenemos la lista de generos de la api
    override suspend fun getGenresListFromApi(): GenresDTO {
        return api.getGenresList()
    }
}