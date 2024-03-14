package com.example.movietest.ui.screens.movies.list

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.movietest.R
import com.example.movietest.ui.components.loading.WaitScreen
import com.example.movietest.ui.screens.movies.list.search.SearchBarScreen
import com.example.movietest.ui.viewmodels.MovieViewModel
import com.example.movietest.ui.viewmodels.RoomViewModel
import kotlin.system.exitProcess

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieListScreen(
    movieViewModel: MovieViewModel,
    navController: NavHostController
) {
    val movieList by movieViewModel.movieList.observeAsState(initial = emptyList())
    var showExitDialog by rememberSaveable { mutableStateOf(false) }

    if (showExitDialog) {
        // Mensaje de confirmacion para salir de la aplicacion
        AlertDialog(
            onDismissRequest = { showExitDialog = false },
            title = { Text(stringResource(R.string.confirm_exit)) },
            text = { Text(stringResource(R.string.confirm_exit_message)) },
            confirmButton = {
                Button(onClick = { exitProcess(0) }) {
                    Text(stringResource(R.string.yes))
                }
            },
            dismissButton = {
                Button(onClick = { showExitDialog = false }) {
                    Text(stringResource(R.string.no))
                }
            }
        )
    }

    if (movieList.isEmpty()) {
        // Pantalla de carga mientras se terminan de obtener todos los datos de las peliculas
        WaitScreen()
    } else {
        // Barra de busqueda con la lista de peliculas disponibles
        SearchBarScreen(
            navController = navController,
            movieList = movieList
        )

        BackHandler(enabled = !showExitDialog) {
            showExitDialog = true
        }
    }
}