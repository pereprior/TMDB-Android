package com.example.movietest.ui.components.utils

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.movietest.ui.theme.StarColor

private const val FILLED_RATING_VALUE = "★"
private const val EMPTY_RATING_VALUE = "☆"

// Barra para mostrar la puntuacion de las peliculas
@Composable
fun RatingBar(
    rating: Double = 0.0,
    stars: Int = 10,
    starSize: Int = 24,
    filledStarColor: Color = StarColor,
    emptyStarColor: Color = MaterialTheme.colorScheme.onSurface
) {
    val filledStars = rating.toInt()

    Row {
        // Se crean tantas estrellas como el usuario quiera (10 por defecto)
        repeat(stars) { starIndex ->
            // Y solo se rellenan las estrellas conforme a la puntuacion de la pelicula
            val isFilled = starIndex < filledStars

            // Plantilla de cada estrella
            StarIcon(
                isFilled = isFilled,
                starSize = starSize,
                filledStarColor = filledStarColor,
                emptyStarColor = emptyStarColor
            )
        }
    }
}

@Composable
private fun StarIcon(
    isFilled: Boolean,
    starSize: Int,
    filledStarColor: Color,
    emptyStarColor: Color
) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = if (isFilled) filledStarColor else emptyStarColor,
                    fontSize = starSize.sp
                )
            ) {
                if (isFilled) append(FILLED_RATING_VALUE) else append(EMPTY_RATING_VALUE)
            }
        }
    )
}