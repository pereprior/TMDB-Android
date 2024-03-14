package com.example.movietest.ui.components.bar.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movietest.R
import com.example.movietest.ui.components.constants.MOVIE_LIST_ROUTE
import com.example.movietest.ui.components.constants.FAVORITE_LIST_ROUTE

@Composable
fun BottomBar(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val barOptions = listOf(
        BottomBarData(
            MOVIE_LIST_ROUTE,
            stringResource(R.string.movies_section),
            Icons.Filled.PlayArrow
        ),

        BottomBarData(
            FAVORITE_LIST_ROUTE,
            stringResource(R.string.favorites_section),
            Icons.Filled.Favorite
        )
    )

    Row(
        modifier = Modifier.fillMaxWidth().background(Color.Black.copy(alpha = 0.3f)),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        barOptions.forEach {
            BottomBarScreen(
                screen = it,
                navController = navController,
                isSelected = it.route == currentRoute
            )
        }
    }
}