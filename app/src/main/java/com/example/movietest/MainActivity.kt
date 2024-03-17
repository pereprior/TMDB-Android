package com.example.movietest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movietest.ui.components.bar.bottom.BottomBar
import com.example.movietest.ui.components.bar.top.TopBar
import com.example.movietest.ui.screens.movies.detail.MovieDetailScreen
import com.example.movietest.ui.screens.movies.list.MovieListScreen
import com.example.movietest.ui.screens.movies.list.FavoritesListScreen
import com.example.movietest.ui.theme.MovieTestTheme
import com.example.movietest.ui.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

const val MOVIES_ROUTE = "MovieView"
const val FAVORITES_ROUTE = "FavoriteView"

private const val TRANSITION_ANIMATION_DURATION = 700

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isSystemInDarkTheme = isSystemInDarkTheme()
            val isdarkTheme = rememberSaveable { mutableStateOf(isSystemInDarkTheme) }

            val navController = rememberNavController()

            val movieViewModel by viewModels<MovieViewModel>()

            MovieTestTheme (
                // Configuración para poder cambiar el tema dentro de la aplicación
                darkTheme = isdarkTheme.value,
                content = {
                    Scaffold(
                        topBar = {
                            // Barra superior con el cambio de tema oscuro/claro
                            TopBar(isdarkTheme)
                        },
                        bottomBar = {
                            // Barra inferior con la navegacion entre las pantallas
                            BottomBar(navController)
                        },
                        content = {
                            // Controlador de la navegacion entre las pantallas
                            NavigationController(
                                navController = navController,
                                viewModel = movieViewModel
                            )
                        }
                    )
                }
            )
        }
    }

    @Composable
    private fun NavigationController(
        navController: NavHostController,
        viewModel: MovieViewModel
    ) {
        NavHost(
            navController = navController,
            startDestination = MOVIES_ROUTE
        ) {
            // Navegación a la pantalla principal con la lista de peliculas
            composable(
                route = MOVIES_ROUTE,
                // Animacion para las transiciones entre pantallas
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(TRANSITION_ANIMATION_DURATION)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(TRANSITION_ANIMATION_DURATION)
                    )
                }
            ) {
                // Listado de peliculas
                MovieListScreen(
                    movieViewModel = viewModel,
                    navController = navController
                )
            }

            // Navegacion a cada pelicula especifica mediante el titulo de esta
            composable(
                route = "$MOVIES_ROUTE/{selectedMovie}",
                arguments = listOf(
                    navArgument("selectedMovie") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val selectedMovie = backStackEntry.arguments?.getString("selectedMovie")
                // Detalles de la pelicula seleccionada
                MovieDetailScreen(
                    movieViewModel = viewModel,
                    selectedMovie = selectedMovie
                )
            }

            // Navegacion a la pantalla de favoritos
            composable(
                route = FAVORITES_ROUTE
            ) {
                // Listado de peliculas favoritas
                FavoritesListScreen(
                    navController = navController,
                    movieViewModel = viewModel,
                )
            }
        }
    }
}