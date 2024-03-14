package com.example.movietest.ui.components.utils

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE

private const val MIN_VALUE = 0f
private const val MAX_VALUE = 10f
private const val ANIMATION_DURATION = 1000
private const val CIRCLE_SIZE = 120

@Composable
fun CircularProgress(value: Float, description: String) {
    // valor inicial del circulo
    var currentProgress by remember { mutableFloatStateOf(MIN_VALUE) }

    LaunchedEffect(key1 = value) {
        // valor final
        currentProgress = value / MAX_VALUE
    }

    // animacion del circulo
    val animatedProgress by animateFloatAsState(
        targetValue = currentProgress,
        animationSpec = tween(
            durationMillis = ANIMATION_DURATION,
            easing = LinearOutSlowInEasing
        ),
        label = "Circle Animation"
    )

    Box(
        modifier = Modifier.size(CIRCLE_SIZE.dp)
    ) {
        // Borde del circulo
        CircularProgressIndicator(
            progress = { animatedProgress },
            modifier = Modifier
                .fillMaxSize()
                .padding(LOW_PADDING_VALUE.dp),
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = LOW_PADDING_VALUE.dp,
        )

        // Descripcion del contenido del circulo
        CircleContent(description, value)
    }
}

@Composable
private fun CircleContent(description: String, value: Float) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(LOW_PADDING_VALUE.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = description)
        Text(text = "$value")
    }
}