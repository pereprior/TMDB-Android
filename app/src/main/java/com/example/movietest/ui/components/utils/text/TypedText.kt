package com.example.movietest.ui.components.utils.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movietest.ui.theme.typography

@Composable
fun TitleTypeText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = typography.titleLarge,
        modifier = modifier,
    )
}