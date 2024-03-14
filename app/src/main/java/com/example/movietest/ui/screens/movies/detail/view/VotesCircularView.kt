package com.example.movietest.ui.screens.movies.detail.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movietest.R
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE
import com.example.movietest.ui.components.utils.text.BoldFormatText
import com.example.movietest.ui.components.utils.CircularProgress

// Vista que muestra el promedio de votos y el numero de votos
@Composable
fun VotesCircularView(
    average: Float,
    count: Float
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(LOW_PADDING_VALUE.dp))

        // Titulo de la tarjeta
        BoldFormatText(title = stringResource(id = R.string.users_votes))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MEDIUM_PADDING_VALUE.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            // Muestra el promedio de votos
            CircularProgress(
                value = average,
                description = stringResource(id = R.string.average)
            )

            // Muestra el numero de votos
            CircularProgress(
                value = count,
                description = stringResource(id = R.string.count)
            )
        }
    }
}