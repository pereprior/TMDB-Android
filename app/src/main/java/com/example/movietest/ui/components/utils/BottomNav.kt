package com.example.movietest.ui.components.utils

/*import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movietest.ui.theme.primaryColor
import com.example.movietest.ui.viewmodels.MovieViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/*@Composable
fun BottomBar(
    navController: NavHostController,
    movieViewModel: MovieViewModel
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val initialSelectedItem = screens.firstOrNull { it.route == currentDestination?.route }
        ?: screens.first()

    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                navController = navController,
                isSelected = screen == initialSelectedItem,
                movieViewModel = movieViewModel
            )
        }
    }
}*/

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun AddItem(
    screen: BottomBarScreen,
    navController: NavHostController,
    isSelected: Boolean,
    movieViewModel: MovieViewModel
) {
    val background = if (isSelected) primaryColor else Color.Transparent

    val contentColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                    // Agrega acciones adicionales si es necesario
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = if (isSelected) screen.iconFocused else screen.icon),
                contentDescription = "icon",
                tint = contentColor
            )

            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = screen.title,
                    color = contentColor
                )
            }
        }
    }
}*/