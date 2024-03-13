package com.example.movietest.data.sources.remote

import android.util.Log
import java.util.Locale

// Lista de los idiomas disponibles en la aplicacion
private val languageMapping = mapOf(
    "es" to "es-ES",
    "en" to "en-US"
)

fun getLanguageKeyForApi(): String {
    val language: String = Locale.getDefault().language
    Log.d("LanguageGetter", "Language: $language")

    // Que busque si el idioma esta en el mapa, si no esta que devuelva el idioma por defecto
    return languageMapping[language] ?: "en-US"
}