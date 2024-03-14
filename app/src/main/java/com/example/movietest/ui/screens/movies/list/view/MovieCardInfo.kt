package com.example.movietest.ui.screens.movies.list.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE
import com.example.movietest.ui.components.constants.MOVIE_LIST_ROUTE
import com.example.movietest.ui.components.utils.text.TitleTypeText
import com.example.movietest.ui.components.utils.ApiImage
import com.example.movietest.ui.components.utils.MovieCard
import com.example.movietest.ui.components.utils.RatingBar

@Composable
fun MovieCardInfo(
    movie: Movie,
    navController: NavHostController,
) {
    MovieCard(
        modifier = Modifier
            .fillMaxSize()
            // Cuando pulsas sobre la tarjeta de cierta pelicula, accedes a la pantalla que contiene la informacion de la misma
            .clickable {
                navController.navigate("$MOVIE_LIST_ROUTE/${movie.title}")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LOW_PADDING_VALUE.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Poster de la pelicula
            ApiImage(movie.posterReference)

            // Titulo de la pelicula
            TitleTypeText(
                text = movie.title,
                modifier = Modifier.padding(LOW_PADDING_VALUE.dp)
            )

            // Barra de la valoracion en estrellas
            RatingBar(rating = movie.voteAverage)
        }
    }
}