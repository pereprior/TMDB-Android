package com.example.movietest.ui.components.error.dialog

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE
import com.example.movietest.ui.components.error.ERROR_DISMISS_TEXT

@Composable
fun NotFoundDialog(
    onDismissRequest: () -> Unit,
    title: String,
    description: String,
) {
    // Se encarga de mandar un mensaje al usuario cuando intenta acceder a una informacion que no existe
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Filled.Warning,
                contentDescription = "Warning Icon",
                tint = Color.Red
            )
        },
        title = {
            Text(
                text = title,
                modifier = Modifier.padding(LOW_PADDING_VALUE.dp),
                color = Color.Red
            )
        },
        text = {
            Text(text = description)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {},
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(ERROR_DISMISS_TEXT)
            }
        }
    )
}