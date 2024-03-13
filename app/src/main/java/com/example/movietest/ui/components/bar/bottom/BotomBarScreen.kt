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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE

@Composable
fun BottomBarScreen(
    screen: BottomBarOption,
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
                .padding(horizontal = 20.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = "icon",
                tint = Color.White
            )

            // El texto solo se muestra si la pantalla esta seleccionada
            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = screen.title,
                    color = Color.White
                )
            }
        }
    }
}