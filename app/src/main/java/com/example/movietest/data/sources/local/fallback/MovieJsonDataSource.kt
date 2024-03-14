package com.example.movietest.data.sources.local.fallback

import android.app.Application
import android.content.Context
import com.example.movietest.data.sources.dto.GenresDTO
import com.example.movietest.data.sources.dto.MovieDTO
import com.example.movietest.domain.repositories.ILocalDataSource
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import javax.inject.Inject

class MovieJsonDataSource @Inject constructor(
    application: Application
): ILocalDataSource {

    private val context: Context = application.applicationContext
    private val gson: Gson = GsonBuilder().create()

    // Obtenemos la lista de peliculas del fichero en caso de fallo
    override fun getMovieListFromFallback(): MovieDTO {
        val fallbackSource = "fallback.json"

        val jsonFile = context.assets.open(fallbackSource).bufferedReader().use { it.readText() }
        return gson.fromJson(jsonFile, MovieDTO::class.java)
    }

    // Obtenemos la lista de generos del fichero en caso de fallo
    override fun getGenresListFromFallback(): GenresDTO {
        val genresFallbackSource = "genres.json"

        val jsonFile = context.assets.open(genresFallbackSource).bufferedReader().use { it.readText() }
        return gson.fromJson(jsonFile, GenresDTO::class.java)
    }

}