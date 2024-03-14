package com.example.movietest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
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
import androidx.room.Room
import com.example.movietest.data.repositories.MovieRoomRepository
import com.example.movietest.data.sources.local.room.FavoriteMovieDataBase
import com.example.movietest.ui.components.bar.bottom.BottomBar
import com.example.movietest.ui.components.bar.top.TopBar
import com.example.movietest.ui.components.constants.MOVIE_LIST_ROUTE
import com.example.movietest.ui.components.constants.FAVORITE_LIST_ROUTE
import com.example.movietest.ui.screens.movies.detail.MovieDetailScreen
import com.example.movietest.ui.screens.movies.list.MovieListScreen
import com.example.movietest.ui.screens.movies.list.FavoritesScreen
import com.example.movietest.ui.theme.MovieTestTheme
import com.example.movietest.ui.viewmodels.MovieViewModel
import com.example.movietest.ui.viewmodels.RoomViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTestTheme {
                val isdarkTheme = rememberSaveable { mutableStateOf(false) }
                val navController = rememberNavController()
                val movieViewModel by viewModels<MovieViewModel>()
                val db = Room.databaseBuilder(
                    this,
                    FavoriteMovieDataBase::class.java,
                    "MovieTestDB"
                ).build()
                val dao = db.dao
                val repository = MovieRoomRepository(dao)
                val roomViewModel = RoomViewModel(repository)

                // Configuramos el tema de la aplicacion
                MovieTestTheme(darkTheme = isdarkTheme.value) {
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
                                movieViewModel = movieViewModel,
                                roomViewModel = roomViewModel
                            )
                        }
                    )
                }
            }
        }
    }

    @Composable
    private fun NavigationController(
        navController: NavHostController,
        movieViewModel: MovieViewModel,
        roomViewModel: RoomViewModel
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
                    roomViewModel = roomViewModel,
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
                    roomViewModel = roomViewModel,
                    selectedMovie = selectedMovie,
                )
            }

            // Navegacion a la pantalla de favoritos
            composable(
                route = FAVORITE_LIST_ROUTE
            ) {
                FavoritesScreen(
                    navController = navController,
                    roomViewModel = roomViewModel
                )
            }
        }
    }
}