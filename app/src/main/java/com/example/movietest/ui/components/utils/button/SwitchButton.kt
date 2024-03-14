package com.example.movietest.ui.components.utils.button

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

// Boton para activar o desactivar una opcion
@Composable
fun SwitchButton(
    value: MutableState<Boolean>
) {
    Switch(
        checked = value.value,
        onCheckedChange = { isChecked ->
            value.value = isChecked
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    )
}