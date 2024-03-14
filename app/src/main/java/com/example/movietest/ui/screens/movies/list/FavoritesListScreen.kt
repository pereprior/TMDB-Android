package com.example.movietest.ui.screens.movies.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.movietest.ui.screens.movies.list.view.MoviesListView
import com.example.movietest.ui.viewmodels.RoomViewModel

// Pantalla que muestra el listado de peliculas favoritas del usuario
@Composable
fun FavoritesListScreen(
    navController: NavHostController,
    roomViewModel: RoomViewModel
) {
    val favoritesList by roomViewModel.favoriteMoviesList.observeAsState(initial = emptyList())

    MoviesListView(
        movieList = favoritesList,
        navController = navController
    )
}