package com.example.movietest.ui.screens.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.movietest.data.constants.IMAGES_URL
import com.example.movietest.domain.models.Movie

@Composable
fun MovieViewHeader(movie: Movie) {
    AsyncImage(
        model = "$IMAGES_URL/w500${movie.imageReference}",
        contentDescription = "Product Image",
        modifier = Modifier.fillMaxWidth()
    )
}