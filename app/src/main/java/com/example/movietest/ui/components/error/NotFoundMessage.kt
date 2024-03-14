package com.example.movietest.ui.components.error

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.movietest.R
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE
import com.example.movietest.ui.theme.typography
import kotlinx.coroutines.delay

// Mensaje de error para mostrar cuando no se encuentran los resultados que se buscan
@Composable
fun NotFoundMessage() {
    var showSearching by remember { mutableStateOf(true) }

    // Se buscan los resultados durante 5 segundos
    LaunchedEffect(true) {
        delay(5000L)
        showSearching = false
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = MEDIUM_PADDING_VALUE.dp),
        contentAlignment = Alignment.Center
    ) {
        // Muestra un indicador de progreso mientras se buscan los resultados
        if (showSearching) {
            CircularProgressIndicator()
        } else {
            // Si no se encuentran resultados, se muestra un mensaje
            Text(
                text = stringResource(id = R.string.no_results),
                style = typography.titleLarge,
                fontStyle = FontStyle.Italic
            )
        }
    }
}