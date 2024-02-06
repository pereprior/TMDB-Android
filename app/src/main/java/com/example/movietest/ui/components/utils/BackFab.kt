package com.example.movietest.ui.components.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun BackFab(
    navController: NavHostController,
    route: String
) {
    FloatingActionButton(
        onClick = { navController.navigate(route) },
        containerColor = MaterialTheme.colorScheme.primary,
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back Button"
        )
    }
}