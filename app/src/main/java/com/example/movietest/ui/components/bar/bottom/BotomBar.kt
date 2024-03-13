package com.example.movietest.ui.components.bar.bottom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movietest.R
import com.example.movietest.ui.components.constants.MOVIE_LIST_ROUTE
import com.example.movietest.ui.components.constants.SETTINGS_ROUTE

private val barOptions = listOf(
    // Pantalla para visualizar las peliculas
    BottomBarOption(
        route = MOVIE_LIST_ROUTE,
        title = "Movies",
        icon = R.drawable.ic_movie
    ),

    // Pantalla para cambiar los ajustes de la app
    BottomBarOption(
        route = SETTINGS_ROUTE,
        title = "Settings",
        icon = R.drawable.ic_settings
    )
)

@Composable
fun BottomBar(navController: NavHostController) {
    // Obtener la pantalla actual
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val initialSelectedItem = barOptions.firstOrNull { it.route == currentDestination?.route }
        ?: barOptions.first()

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Mostrar los iconos para navegar entre las pantallas
        barOptions.forEach { screen ->
            BottomBarScreen(
                screen = screen,
                navController = navController,
                isSelected = screen == initialSelectedItem
            )
        }
    }
}