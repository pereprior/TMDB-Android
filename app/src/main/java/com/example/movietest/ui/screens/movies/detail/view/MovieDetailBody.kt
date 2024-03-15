package com.example.movietest.ui.screens.movies.detail.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movietest.R
import com.example.movietest.domain.models.Movie
import com.example.movietest.constants.BANNER_PADDING_VALUE
import com.example.movietest.constants.HIGH_PADDING_VALUE
import com.example.movietest.constants.MEDIUM_PADDING_VALUE
import com.example.movietest.ui.components.utils.text.BoldFormatText
import com.example.movietest.ui.components.utils.text.BoldListFormatText
import com.example.movietest.ui.components.utils.MovieCard

@Composable
fun MovieDetailBody(movie: Movie) {
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
                    val movieInfo = mapOf(
                        stringResource(id = R.string.original_title) to movie.originalTitle,
                        stringResource(id = R.string.original_language) to movie.originalLanguage,
                        stringResource(id = R.string.release_date) to movie.releaseDate,
                        stringResource(id = R.string.overview) to movie.overview
                    )

                    // Muestra la lista de generos de la pelicula
                    BoldListFormatText(
                        title = stringResource(id = R.string.genres),
                        list = movie.genres
                    )

                    // Muestra la informacion adicional
                    movieInfo.map {
                        BoldFormatText(
                            title = it.key,
                            text = it.value
                        )
                    }

                    Spacer(modifier = Modifier.padding(MEDIUM_PADDING_VALUE.dp))
                }
            )

            MovieCard(
                modifier = Modifier.width(BANNER_PADDING_VALUE.dp),
                content = {
                    // Votos de los usuarios en formato de circulo
                    VotesCircularView(
                        average = movie.voteAverage.toFloat(),
                        count = movie.voteCount.toFloat()
                    )
                }
            )
        }
    )
}