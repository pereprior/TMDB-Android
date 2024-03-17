package com.example.movietest.ui.components.error

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.movietest.R
import com.example.movietest.ui.components.text.TitleTypeText
import kotlin.system.exitProcess

// Mensaje de confirmacion para salir de la aplicacion
@Composable
fun AlertExitDialog(
    onDismiss: () -> Unit,
    title: String = stringResource(R.string.confirm_exit),
    message: String = stringResource(R.string.confirm_exit_message),
    confirmButtonMessage: String = stringResource(R.string.yes),
    dismissButtonMessage: String = stringResource(R.string.no)
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { TitleTypeText(title) },
        text = { Text(text = message, color = MaterialTheme.colorScheme.onSurface) },
        confirmButton = {
            // Boton para salir de la aplicacion
            Button(onClick = { exitProcess(0) }) {
                Text(text = confirmButtonMessage)
            }
        },
        dismissButton = {
            // Boton para volver a la pantalla principal
            Button(onClick = { onDismiss() }) {
                Text(text = dismissButtonMessage)
            }
        },
        shape = MaterialTheme.shapes.medium,
        containerColor = MaterialTheme.colorScheme.surface,
    )
}