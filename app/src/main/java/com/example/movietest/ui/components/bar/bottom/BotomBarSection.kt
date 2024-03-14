package com.example.movietest.ui.components.bar.bottom

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE

@Composable
fun BottomBarScreen(
    screen: BottomBarData,
    navController: NavHostController,
    isSelected: Boolean
) {
    // Se mostrará de manera visual la pantalla en la que nos encontramos
    val background =
        if (isSelected) MaterialTheme.colorScheme.tertiary else Color.Transparent

    Box(
        modifier = Modifier
            .padding(MEDIUM_PADDING_VALUE.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(
                onClick = { navController.navigate(screen.route) }
            )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = MEDIUM_PADDING_VALUE.dp, vertical = LOW_PADDING_VALUE.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = screen.icon,
                contentDescription = "icon",
                tint = MaterialTheme.colorScheme.onTertiary
            )

            // El texto solo se muestra si la pantalla esta seleccionada
            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = screen.title,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
        }
    }
}