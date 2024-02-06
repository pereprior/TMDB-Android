package com.example.movietest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movietest.ui.components.constants.MOVIE_LIST_ROUTE
import com.example.movietest.ui.screens.detail.MovieDetailScreen
import com.example.movietest.ui.screens.list.MovieListScreen
import com.example.movietest.ui.theme.MovieTestTheme
import com.example.movietest.ui.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTestTheme {
                val navController = rememberNavController()
                val movieViewModel by viewModels<MovieViewModel>()

                NavigationController(navController, movieViewModel)
            }
        }
    }

    @Composable
    private fun NavigationController(
        navController: NavHostController,
        movieViewModel: MovieViewModel
    ) {
        NavHost(
            navController = navController,
            startDestination = MOVIE_LIST_ROUTE,

        ) {
            // Navegación a la pantalla principal con la lista de peliculas
            composable(
                route = MOVIE_LIST_ROUTE,
                // Transiciones entre pantallas
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                }
            ) {
                MovieListScreen(
                    movieViewModel = movieViewModel,
                    navController = navController
                )
            }

            // Navegacion a cada pelicula especifica mediante el titulo de esta
            composable(
                route = "$MOVIE_LIST_ROUTE/{selectedMovie}",
                arguments = listOf(
                    navArgument("selectedMovie") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val selectedMovie = backStackEntry.arguments?.getString("selectedMovie")
                MovieDetailScreen(
                    movieViewModel = movieViewModel,
                    selectedMovie = selectedMovie,
                    navController = navController
                )
            }
        }
    }
}