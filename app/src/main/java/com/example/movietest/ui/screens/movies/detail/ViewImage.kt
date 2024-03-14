package com.example.movietest.ui.screens.movies.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movietest.data.constants.IMAGES_URL
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.constants.BANNER_PADDING_VALUE

private const val IMAGE_WIDTH = "/w500"

@Composable
fun MovieViewHead(movie: Movie) {
    AsyncImage(
        model = "$IMAGES_URL$IMAGE_WIDTH${movie.imageReference}",
        contentDescription = "Product Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(BANNER_PADDING_VALUE.dp)
    )
}