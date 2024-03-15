package com.example.movietest.constants

import android.annotation.SuppressLint
import java.util.Locale

// Constantes para obtener el idioma en la api
const val LANGUAGE_ENTRY = "&language="

// Lista de los idiomas disponibles en la aplicacion
private val languageMapping = mapOf(
    "es" to "es-ES",
    "en" to "en-US"
)

// Idioma por defecto del dispositivo
@SuppressLint("ConstantLocale")
val DEFAULT_LANGUAGE: String? = Locale.getDefault().language
val DEFAULT_LANGUAGE_FOR_API = languageMapping[DEFAULT_LANGUAGE] ?: "en-US"