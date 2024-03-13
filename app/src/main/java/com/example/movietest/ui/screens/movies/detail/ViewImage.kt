package com.example.movietest.ui.screens.movies.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.movietest.data.constants.IMAGES_URL
import com.example.movietest.domain.models.Movie

@Composable
fun MovieViewImage(movie: Movie) {
    Box (
        modifier = Modifier.fillMaxWidth()
    ) {
        AsyncImage(
            model = "$IMAGES_URL/w500${movie.imageReference}",
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.78f)
        )
    }
}