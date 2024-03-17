package com.example.movietest.data.sources

import com.example.movietest.data.api.API_KEY
import com.example.movietest.data.api.IApiService
import com.example.movietest.data.api.DEFAULT_LANGUAGE_FOR_API
import com.example.movietest.data.api.dto.GenresDTO
import com.example.movietest.data.api.dto.MovieDTO

class MovieRemoteDataSource (
    private val api: IApiService
) {
    // Obtenemos la lista de peliculas de la api
    suspend fun getMovieListFromApi(): MovieDTO {
        return api.getMovieList(
            apiKey = API_KEY,
            language = DEFAULT_LANGUAGE_FOR_API
        )
    }

    // Obtenemos la lista de generos de la api
    suspend fun getGenresListFromApi(): GenresDTO {
        return api.getGenresList(
            apiKey = API_KEY,
            language = DEFAULT_LANGUAGE_FOR_API
        )
    }
}