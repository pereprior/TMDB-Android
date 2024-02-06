package com.example.movietest.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.constants.HIGH_PADDING_VALUE
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE
import com.example.movietest.ui.components.utils.BoldFormatText
import com.example.movietest.ui.components.utils.BoldListFormatText
import com.example.movietest.ui.components.utils.CircularProgress

@Composable
fun MovieViewBody(movie: Movie) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            item {
                Card(
                    modifier = Modifier.padding(
                        vertical = MEDIUM_PADDING_VALUE.dp,
                        horizontal = HIGH_PADDING_VALUE.dp
                    )
                ) {
                    Spacer(modifier = Modifier.padding(MEDIUM_PADDING_VALUE.dp))
                    // Informacion sobre la pelicula
                    BoldFormatText("Original title: ", movie.originalTitle)
                    BoldFormatText("Original language: ", movie.originalLanguage)
                    BoldFormatText("Release date: ", movie.releaseDate)

                    BoldListFormatText("Genres: ", movie.genres)

                    BoldFormatText("Overview: ", movie.overview)
                    Spacer(modifier = Modifier.padding(MEDIUM_PADDING_VALUE.dp))
                }

                // Votos de los usuarios en formato de circulo
                VotesCircularComponent(movie)
            }
        }
    )
}

@Composable
private fun VotesCircularComponent(movie: Movie) {
    Text(
        text = "Users votes:",
        fontWeight = FontWeight.Bold
    )

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        CircularProgress(movie.voteAverage.toFloat(), "Average")
        CircularProgress(movie.voteCount.toFloat(), "Count")
    }
}