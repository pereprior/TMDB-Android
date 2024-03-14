package com.example.movietest.ui.components.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movietest.ui.components.constants.HIGH_PADDING_VALUE
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE

// Plantilla para las tarjetas de informacion de las peliculas
@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,

) {
    Card(
        modifier = modifier
            .padding(vertical = MEDIUM_PADDING_VALUE.dp, horizontal = HIGH_PADDING_VALUE.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = LOW_PADDING_VALUE.dp),
        shape = RoundedCornerShape(MEDIUM_PADDING_VALUE.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        content()
    }
}