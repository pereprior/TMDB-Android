package com.example.movietest.ui.components.loading

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movietest.R
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE

const val ANIMATION_DELAY_IN_MILLIS = 500

@Composable
fun WaitScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icono de la pantalla de carga
        LoadingImage(R.drawable.ic_launcher_icon)
        Spacer(modifier = Modifier.padding(LOW_PADDING_VALUE.dp))

        // Texto de la pantalla de carga
        LoadingText(stringResource(id = R.string.loading_title))
        Text(text = stringResource(id = R.string.loading_description))
    }
}