package com.example.movietest.data.sources

import android.util.Log
import com.example.movietest.data.api.IApiService
import com.example.movietest.constants.DEFAULT_LANGUAGE_FOR_API
import com.example.movietest.data.api.dto.GenresDTO
import com.example.movietest.data.api.dto.MovieDTO

class MovieRemoteDataSource (
    private val api: IApiService
) {
    // Obtenemos la lista de peliculas de la api
    suspend fun getMovieListFromApi(): MovieDTO {
        Log.d("LanguageGetter", "Language: $DEFAULT_LANGUAGE_FOR_API")
        return api.getMovieList(DEFAULT_LANGUAGE_FOR_API)
    }

    // Obtenemos la lista de generos de la api
    suspend fun getGenresListFromApi(): GenresDTO {
        return api.getGenresList(DEFAULT_LANGUAGE_FOR_API)
    }
}