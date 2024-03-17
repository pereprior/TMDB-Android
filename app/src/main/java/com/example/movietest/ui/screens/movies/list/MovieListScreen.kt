package com.example.movietest.ui.screens.movies.list

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.movietest.ui.components.error.AlertExitDialog
import com.example.movietest.ui.components.anim.WaitScreen
import com.example.movietest.ui.screens.movies.list.view.SearchBarView
import com.example.movietest.ui.viewmodels.MovieViewModel

// Pantalla principal de la aplicación, donde se muestra el listado de peliculas
@Composable
fun MovieListScreen(
    movieViewModel: MovieViewModel,
    navController: NavHostController
) {
    val movieList by movieViewModel.movieList.observeAsState(initial = emptyList())
    var showExitDialog by rememberSaveable { mutableStateOf(false) }

    if (showExitDialog) {
        // Mensaje de confirmación para salir de la app
        AlertExitDialog(
            onDismiss = { showExitDialog = false }
        )
    }

    if (movieList.isEmpty()) {
        // Pantalla de carga mientras se obtienen los datos de la api
        WaitScreen()
    } else {
        // Listado de peliculas con su barra de busqueda
        SearchBarView(
            navController = navController,
            movieList = movieList
        )

        // Si el usuario pulsa el boton hacia atras saldrá un mensage preguntado si queremos salir de la app
        BackHandler(enabled = !showExitDialog) {
            showExitDialog = true
        }
    }
}