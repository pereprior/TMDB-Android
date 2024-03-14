package com.example.movietest.ui.screens.movies.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.movietest.R
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.constants.BANNER_PADDING_VALUE
import com.example.movietest.ui.components.constants.HIGH_PADDING_VALUE
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE
import com.example.movietest.ui.components.constants.TOP_BAR_PADDING_VALUE
import com.example.movietest.ui.components.utils.BoldFormatText
import com.example.movietest.ui.components.utils.BoldListFormatText
import com.example.movietest.ui.components.utils.CircularProgress
import com.example.movietest.ui.components.utils.MovieCard

@Composable
fun MovieViewBody(movie: Movie) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(HIGH_PADDING_VALUE.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            MovieCard(
                content = {
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
            )

            MovieCard(
                modifier = Modifier.width(BANNER_PADDING_VALUE.dp),
                content = {
                    // Votos de los usuarios en formato de circulo
                    VotesCircularComponent(movie)
                }
            )
        }
    )
}

@Composable
private fun VotesCircularComponent(
    movie: Movie
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(LOW_PADDING_VALUE.dp))

        Text(
            text = stringResource(id = R.string.users_votes),
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MEDIUM_PADDING_VALUE.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgress(movie.voteAverage.toFloat(), stringResource(id = R.string.average))
            CircularProgress(movie.voteCount.toFloat(), stringResource(id = R.string.count))
        }
    }
}