package com.example.movietest.ui.components.utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE
import com.example.movietest.ui.theme.ErrorColor
import com.example.movietest.ui.viewmodels.RoomViewModel

@Composable
fun FavoriteIcon(
    movie: Movie,
    roomViewModel: RoomViewModel
) {
    var isFilled by rememberSaveable { mutableStateOf(false) }

    IconButton(
        modifier = Modifier.padding(LOW_PADDING_VALUE.dp),
        onClick = {
            /*if (isFilled) roomViewModel.removeMovie(movie)
            else roomViewModel.saveMovie(movie)*/

            isFilled = !isFilled
        }
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(0.8f),
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Favorite icon",
            tint = if (isFilled) ErrorColor
            else Color.White,
        )
    }
}