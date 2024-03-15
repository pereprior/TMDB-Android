package com.example.movietest.data.api

import com.example.movietest.constants.API_ENDPOINT
import com.example.movietest.constants.GENRES_ENDPOINT
import com.example.movietest.data.api.dto.GenresDTO
import com.example.movietest.data.api.dto.MovieDTO
import com.example.movietest.constants.DEFAULT_URL_SET
import retrofit2.http.GET
import retrofit2.http.Query

// Peticiones GET a la api para obtener los datos
interface IApiService {
    @GET("$API_ENDPOINT$DEFAULT_URL_SET")
    suspend fun getMovieList(
        @Query("language") language: String
    ): MovieDTO

    @GET("$GENRES_ENDPOINT$DEFAULT_URL_SET")
    suspend fun getGenresList(
        @Query("language") language: String
    ): GenresDTO
}