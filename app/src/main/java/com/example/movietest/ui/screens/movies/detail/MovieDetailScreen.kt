package com.example.movietest.ui.screens.movies.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.movietest.ui.components.constants.BANNER_PADDING_VALUE
import com.example.movietest.ui.components.constants.HIGH_PADDING_VALUE
import com.example.movietest.ui.components.constants.TOP_BAR_PADDING_VALUE
import com.example.movietest.ui.components.utils.ApiImage
import com.example.movietest.ui.components.utils.button.FavoriteIcon
import com.example.movietest.ui.screens.movies.detail.view.MovieDetailBody
import com.example.movietest.ui.viewmodels.MovieViewModel
import com.example.movietest.ui.viewmodels.RoomViewModel

@Composable
fun MovieDetailScreen (
    movieViewModel: MovieViewModel,
    roomViewModel: RoomViewModel,
    selectedMovie: String?,
) {
    val movie = movieViewModel.getMovieByTitle(selectedMovie!!)

    // Si la pelicula existe, muestra el contenido
    movie?.let {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = TOP_BAR_PADDING_VALUE.dp)
        ) {
            Column (
                modifier = Modifier.verticalScroll(rememberScrollState()),
                content = {
                    // Imagen de la pelicula
                    ApiImage(
                        imageReference = movie.imageReference,
                        scale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(BANNER_PADDING_VALUE.dp)
                    )

                    // Descripcion e informacion adicional de la pelicula
                    MovieDetailBody(movie = movie)

                    Spacer(modifier = Modifier.padding(HIGH_PADDING_VALUE.dp))
                }
            )

            // Boton de favoritos
            FavoriteIcon(
                movie = movie,
                roomViewModel = roomViewModel
            )
        }
    }
}