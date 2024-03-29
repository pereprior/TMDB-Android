package com.example.movietest.ui.components.utils

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun DrawableIcon(
    painter: Int,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = painter),
        contentDescription = "themes icon",
        tint = MaterialTheme.colorScheme.onSecondary,
        modifier = modifier
    )
}