package com.example.movietest.ui.components.bar.top

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movietest.R
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE
import com.example.movietest.ui.components.constants.TOP_BAR_PADDING_VALUE
import com.example.movietest.ui.components.utils.DrawableIcon
import com.example.movietest.ui.components.utils.button.SwitchButton
import com.example.movietest.ui.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(isDarkTheme: MutableState<Boolean>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_BAR_PADDING_VALUE.dp)
    ) {
        TopAppBar(
            // Logo de la aplicacion
            navigationIcon = { DrawableIcon(R.drawable.ic_launcher_icon) },
            // Nombre de la aplicacion
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            },
            actions = {
                // Cambio de tema oscuro/claro
                Row (
                    modifier = Modifier
                        .padding(LOW_PADDING_VALUE.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DrawableIcon(R.drawable.ic_themes)

                    Spacer(modifier = Modifier.padding(LOW_PADDING_VALUE.dp))

                    // Boton para cambiar el tema
                    SwitchButton(isDarkTheme)
                }
            },
            colors = topAppBarColors(MaterialTheme.colorScheme.secondary)
        )
    }
}