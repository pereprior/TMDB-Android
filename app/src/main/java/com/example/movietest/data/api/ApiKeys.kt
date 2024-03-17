package com.example.movietest.data.api

import android.annotation.SuppressLint
import java.util.Locale

// Credenciales de la api
const val API_URL = "https://api.themoviedb.org/3/"
const val API_POPULAR_ENDPOINT = "movie/popular"
const val API_NOW_PLAYING_ENDPOINT = "movie/now_playing"
const val API_TOP_RATED_ENDPOINT = "movie/top_rated"
const val API_UPCOMING_ENDPOINT = "movie/upcoming"
const val GENRES_ENDPOINT = "genre/movie/list"
const val API_KEY = "01724eed9b4a6b5588236a1bfb15a4ed"

// Lista de los idiomas disponibles en la aplicacion
private val languageMapping = mapOf(
    "es" to "es-ES",
    "en" to "en-US"
)

// Idioma por defecto del dispositivo
@SuppressLint("ConstantLocale")
val DEFAULT_LANGUAGE: String? = Locale.getDefault().language
val DEFAULT_LANGUAGE_FOR_API = languageMapping[DEFAULT_LANGUAGE] ?: "en-US"