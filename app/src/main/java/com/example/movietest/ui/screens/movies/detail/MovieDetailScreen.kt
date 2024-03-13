package com.example.movietest.ui.screens.movies.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movietest.ui.components.constants.TOP_BAR_PADDING_VALUE
import com.example.movietest.ui.viewmodels.MovieViewModel

@Composable
fun MovieDetailScreen (
    movieViewModel: MovieViewModel,
    selectedMovie: String?,
) {
    val movie = movieViewModel.getMovieByTitle(selectedMovie!!)

    // Si la pelicula existe, muestra el contenido
    movie?.let {
        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(top = TOP_BAR_PADDING_VALUE.dp),
            content = {
                // Descripcion e informacion adicional de la pelicula
                MovieViewBody(movie)

                // Imagen de la pelicula
                MovieViewImage(movie)
            }
        )
    }
}