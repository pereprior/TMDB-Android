package com.example.movietest.ui.screens.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.movietest.ui.components.loading.WaitScreen
import com.example.movietest.ui.screens.list.search.SearchBarScreen
import com.example.movietest.ui.viewmodels.MovieViewModel

@Composable
fun MovieListScreen(
    movieViewModel: MovieViewModel,
    navController: NavHostController
) {
    val movieList by movieViewModel.movieList.observeAsState(initial = emptyList())

    if (movieList.isEmpty()) {
        // Pantalla de carga mientras se terminan de obtener todos los datos de las peliculas
        WaitScreen()
    } else {
        // Barra de busqueda con la lista de peliculas disponibles
        SearchBarScreen(
            navController = navController,
            movieList = movieList,
            route = ""
        )
    }
}