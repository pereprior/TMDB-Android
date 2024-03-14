package com.example.movietest.ui.screens.movies.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.movietest.R
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.constants.HIGH_PADDING_VALUE
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE
import com.example.movietest.ui.components.utils.BoldFormatText
import com.example.movietest.ui.components.utils.BoldListFormatText
import com.example.movietest.ui.components.utils.CircularProgress

@Composable
fun MovieViewBody(movie: Movie) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(HIGH_PADDING_VALUE.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Card(
                modifier = Modifier.padding(
                    vertical = MEDIUM_PADDING_VALUE.dp,
                    horizontal = HIGH_PADDING_VALUE.dp
                )
            ) {
                Spacer(modifier = Modifier.padding(MEDIUM_PADDING_VALUE.dp))
                // Informacion sobre la pelicula
                BoldFormatText(
                    title = stringResource(id = R.string.original_title),
                    text = movie.originalTitle
                )
                BoldFormatText(
                    title = stringResource(id = R.string.original_language),
                    text = movie.originalLanguage
                )
                BoldFormatText(
                    title = stringResource(id = R.string.release_date),
                    text = movie.releaseDate
                )

                BoldListFormatText(
                    title = stringResource(id = R.string.genres),
                    list = movie.genres
                )

                BoldFormatText(
                    title = stringResource(id = R.string.overview),
                    text = movie.overview
                )
                Spacer(modifier = Modifier.padding(MEDIUM_PADDING_VALUE.dp))
            }

            // Votos de los usuarios en formato de circulo
            VotesCircularComponent(movie)
        }
    )
}

@Composable
private fun VotesCircularComponent(
    movie: Movie
) {
    Text(
        text = stringResource(id = R.string.users_votes),
        fontWeight = FontWeight.Bold
    )

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        CircularProgress(movie.voteAverage.toFloat(), stringResource(id = R.string.average))
        CircularProgress(movie.voteCount.toFloat(), stringResource(id = R.string.count))
    }
}