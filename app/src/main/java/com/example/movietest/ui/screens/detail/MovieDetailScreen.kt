package com.example.movietest.ui.screens.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.movietest.ui.components.constants.MOVIE_LIST_ROUTE
import com.example.movietest.ui.components.utils.BackFab
import com.example.movietest.ui.viewmodels.MovieViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieDetailScreen (
    movieViewModel: MovieViewModel,
    selectedMovie: String?,
    navController: NavHostController
) {
    val movie = movieViewModel.getMovieByTitle(selectedMovie!!)

    // Si la pelicula existe, muestra el contenido
    movie?.let {
        Scaffold (
            floatingActionButton = {
                // Boton para volver a la pantalla con la lista de peliculas
                BackFab(
                    navController = navController,
                    route = MOVIE_LIST_ROUTE
                )
            }
        ) {
            Column (
                modifier = Modifier.verticalScroll(rememberScrollState()),
                content = {
                    // Imagen de la pelicula
                    MovieViewHeader(movie)

                    // Descripcion e informacion adicional de la pelicula
                    MovieViewBody(movie)
                }
            )
        }
    }
}