package com.example.movietest.ui.components.anim

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.example.movietest.ui.theme.typography
import kotlinx.coroutines.delay

private const val LOADING_VALUE = "."
private const val MAX_DOTS = 3
private const val DOT_GROUP = 1

@Composable
fun LoadingText(
    message: String,
    style: TextStyle = typography.bodyLarge,
) {
    var valueCount by rememberSaveable { mutableIntStateOf(1) }

    // Mientras dure la pantalla de carga, ira apareciendo y despareciendo para dar sensacion de carga
    LaunchedEffect(Unit) {
        while (true) {
            // Frecuencia en la que el texto va cargando
            delay(ANIMATION_DELAY_IN_MILLIS.toLong())
            valueCount = (valueCount % MAX_DOTS) + DOT_GROUP
        }
    }

    val loadingText = buildAnnotatedString {
        // Texto estatico
        append(message)

        // Texto animado
        repeat(valueCount) {
            append(LOADING_VALUE)
        }
    }

    Text(
        text = loadingText,
        style = style
    )
}