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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movietest.R
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE
import com.example.movietest.ui.theme.errorColor

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
                tint = errorColor
            )
        },
        title = {
            Text(
                text = title,
                modifier = Modifier.padding(LOW_PADDING_VALUE.dp),
                color = errorColor
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
                Text(
                    text = stringResource(id = R.string.error_dismiss_text),
                    color = errorColor
                )
            }
        }
    )
}