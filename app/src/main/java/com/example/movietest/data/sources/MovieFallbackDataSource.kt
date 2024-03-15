package com.example.movietest.data.sources

import android.app.Application
import android.content.Context
import com.example.movietest.data.api.dto.GenresDTO
import com.example.movietest.data.api.dto.MovieDTO
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import javax.inject.Inject

class MovieFallbackDataSource @Inject constructor(
    application: Application
) {

    private val context: Context = application.applicationContext
    private val gson: Gson = GsonBuilder().create()

    // Obtenemos la lista de peliculas del fichero en caso de fallo
    fun getMovieListFromFallback(): MovieDTO {
        val fallbackSource = "fallback.json"

        val jsonFile = context.assets.open(fallbackSource).bufferedReader().use { it.readText() }
        return gson.fromJson(jsonFile, MovieDTO::class.java)
    }

    // Obtenemos la lista de generos del fichero en caso de fallo
    fun getGenresListFromFallback(): GenresDTO {
        val genresFallbackSource = "genres.json"

        val jsonFile = context.assets.open(genresFallbackSource).bufferedReader().use { it.readText() }
        return gson.fromJson(jsonFile, GenresDTO::class.java)
    }

}