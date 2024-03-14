package com.example.movietest.ui.components.bar.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movietest.ui.components.constants.MOVIE_LIST_ROUTE
import com.example.movietest.ui.components.constants.FAVORITE_LIST_ROUTE

private val barOptions = listOf(
    // Pantalla para visualizar las peliculas
    BottomBarOption(
        route = MOVIE_LIST_ROUTE,
        title = "Movies",
        icon = Icons.Filled.PlayArrow
    ),

    // Pantalla para cambiar los ajustes de la app
    BottomBarOption(
        route = FAVORITE_LIST_ROUTE,
        title = "Favorites",
        icon = Icons.Filled.Favorite
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
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.3f)),
        horizontalArrangement = Arrangement.SpaceEvenly,
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