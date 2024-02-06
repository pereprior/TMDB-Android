package com.example.movietest.data.sources.remote

import com.example.movietest.data.constants.API_ENDPOINT
import com.example.movietest.data.constants.API_KEY
import com.example.movietest.data.constants.GENRES_ENDPOINT
import com.example.movietest.data.sources.dto.GenresDTO
import com.example.movietest.data.sources.dto.MovieDTO
import retrofit2.http.GET

private const val KEY_ENTRY = "?api_key="

// Peticiones GET a la api para obtener los datos
interface IApiService {
    @GET("$API_ENDPOINT$KEY_ENTRY$API_KEY")
    suspend fun getMovieList(): MovieDTO

    @GET("$GENRES_ENDPOINT$KEY_ENTRY$API_KEY")
    suspend fun getGenresList(): GenresDTO
}