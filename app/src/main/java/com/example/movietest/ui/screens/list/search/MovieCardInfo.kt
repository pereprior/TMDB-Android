package com.example.movietest.ui.screens.list.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.movietest.data.constants.IMAGES_URL
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.constants.HIGH_PADDING_VALUE
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE
import com.example.movietest.ui.components.constants.MOVIE_LIST_ROUTE
import com.example.movietest.ui.components.utils.RatingBar
import com.example.movietest.ui.theme.typography

@Composable
fun MovieCardInfo(movie: Movie, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(HIGH_PADDING_VALUE.dp)
            .clickable {
                navController.navigate("$MOVIE_LIST_ROUTE/${movie.title}")
            },
        elevation = CardDefaults.cardElevation(defaultElevation = LOW_PADDING_VALUE.dp),
        shape = RoundedCornerShape(MEDIUM_PADDING_VALUE.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LOW_PADDING_VALUE.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Poster de la pelicula
            MoviePosterImage(movie.posterReference)

            // Titulo de la pelicula
            MovieTitle(movie.title)

            // Barra de la valoracion en estrellas
            RatingBar(rating = movie.voteAverage)
        }
    }
}

@Composable
private fun MoviePosterImage(posterReference: String) {
    AsyncImage(
        model = "$IMAGES_URL/w500$posterReference",
        contentDescription = "Movie Poster",
    )
}

@Composable
private fun MovieTitle(title: String) {

    Text(
        text = title,
        style = typography.titleLarge,
        modifier = Modifier.padding(top = 8.dp),
    )
}
