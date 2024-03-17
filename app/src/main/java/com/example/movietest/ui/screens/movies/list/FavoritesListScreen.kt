package com.example.movietest.ui.screens.movies.list

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movietest.ui.components.utils.TOP_BAR_PADDING_VALUE
import com.example.movietest.ui.screens.movies.list.view.MoviesListView
import com.example.movietest.ui.viewmodels.MovieViewModel

// Pantalla que muestra el listado de peliculas favoritas del usuario
@Composable
fun FavoritesListScreen(
    navController: NavHostController,
    movieViewModel: MovieViewModel
) {
    val favoritesList by movieViewModel.favoriteMoviesList.observeAsState(initial = emptyList())

    MoviesListView(
        movieList = favoritesList,
        navController = navController,
        modifier = Modifier.padding(top = TOP_BAR_PADDING_VALUE.dp)
    )
}