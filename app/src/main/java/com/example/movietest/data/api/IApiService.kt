package com.example.movietest.data.api

import com.example.movietest.data.api.dto.GenresDTO
import com.example.movietest.data.api.dto.MovieDTO
import retrofit2.http.GET
import retrofit2.http.Query

// Peticiones GET a la api para obtener los datos
interface IApiService {
    @GET(API_POPULAR_ENDPOINT)
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): MovieDTO

    @GET(GENRES_ENDPOINT)
    suspend fun getGenresList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): GenresDTO
}