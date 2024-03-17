package com.example.movietest.ui.components.anim

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.utils.LOW_PADDING_VALUE
import com.example.movietest.ui.theme.ErrorColor
import com.example.movietest.ui.viewmodels.MovieViewModel

@Composable
fun FavoriteButton(
    movie: Movie,
    movieViewModel: MovieViewModel
) {
    var isFilled: Boolean by rememberSaveable { mutableStateOf(movieViewModel.isFavoriteByTitle(movie.title)) }
    val animatedColor by animateColorAsState(if (isFilled) ErrorColor else Color.White, label = "Favorite Color")

    IconButton(
        modifier = Modifier
            .padding(LOW_PADDING_VALUE.dp)
            .background(
                color = Color.Black.copy(alpha = 0.3f),
                shape = CircleShape
            ),
        onClick = {
            if (isFilled) movieViewModel.removeMovie(movie)
            else movieViewModel.saveMovie(movie)

            isFilled = !isFilled
        }
    ) {
        // Icono del corazon
        Icon(
            modifier = Modifier.fillMaxSize(0.8f),
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Favorite icon",
            tint = animatedColor,
        )
    }
}