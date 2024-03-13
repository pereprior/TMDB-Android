package com.example.movietest.data.sources.remote

import com.example.movietest.data.constants.API_ENDPOINT
import com.example.movietest.data.constants.API_KEY
import com.example.movietest.data.constants.GENRES_ENDPOINT
import com.example.movietest.data.constants.KEY_ENTRY
import com.example.movietest.data.constants.LANGUAGE_ENTRY
import com.example.movietest.data.sources.dto.GenresDTO
import com.example.movietest.data.sources.dto.MovieDTO
import retrofit2.http.GET
import retrofit2.http.Query


private const val DEFAULT_URL_SET = "$KEY_ENTRY$API_KEY$LANGUAGE_ENTRY"
val DEFAULT_LANGUAGE = getLanguageKeyForApi()

// Peticiones GET a la api para obtener los datos
interface IApiService {
    @GET("$API_ENDPOINT$DEFAULT_URL_SET")
    suspend fun getMovieList(
        @Query("language") language:String = DEFAULT_LANGUAGE
    ): MovieDTO

    @GET("$GENRES_ENDPOINT$DEFAULT_URL_SET")
    suspend fun getGenresList(
        @Query("language") language:String = DEFAULT_LANGUAGE
    ): GenresDTO
}