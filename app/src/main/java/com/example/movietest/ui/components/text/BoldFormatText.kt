package com.example.movietest.ui.components.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.movietest.ui.components.utils.HIGH_PADDING_VALUE
import com.example.movietest.ui.theme.typography

@Composable
fun BoldFormatText(
    title: String,
    text: String = ""
) {
    Text(
        text = buildAnnotatedString {
            // Titulo del texto en negrita
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontFamily = typography.titleLarge.fontFamily)) {
                append(title)
            }

            // Texto sin negrita
            append(text)
        },
        modifier = Modifier.padding(horizontal = HIGH_PADDING_VALUE.dp)
    )
}

@Composable
fun BoldListFormatText(
    title: String,
    list: List<String>
) {
    Text(
        text = buildAnnotatedString {
            // Titulo del texto en negrita
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontFamily = typography.titleLarge.fontFamily)) {
                append(title)
            }

            // Lista de objetos separados por comas
            list.forEachIndexed { index, item ->
                if (index < list.size -1) {
                    append("$item, ")
                } else {
                    append(item)
                }
            }
        },
        modifier = Modifier.padding(horizontal = HIGH_PADDING_VALUE.dp)
    )
}