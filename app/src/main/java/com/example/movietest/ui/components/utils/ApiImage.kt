package com.example.movietest.ui.components.utils

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

private const val IMAGES_URL = "https://image.tmdb.org/t/p"
private const val IMAGE_WIDTH = "/w500"

// Plantilla para mostrar imagenes desde una url obtenida de la api
@Composable
fun ApiImage(
    imageReference: String,
    scale: ContentScale = ContentScale.None,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    AsyncImage(
        model = "$IMAGES_URL$IMAGE_WIDTH$imageReference",
        contentDescription = "Movie Poster",
        contentScale = scale,
        modifier = modifier
    )
}