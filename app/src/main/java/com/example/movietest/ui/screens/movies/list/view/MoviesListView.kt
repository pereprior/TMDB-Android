package com.example.movietest.ui.screens.movies.list.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.error.NotFoundMessage

// Contenido con la lista de las peliculas disponibles
@Composable
fun MoviesListView(
    movieList: List<Movie>,
    navController: NavHostController
) {
    if (movieList.isEmpty()) {
        // Muetsra un mensaje si no se encuentran resultados
        NotFoundMessage()
    } else {
        // Muestra la lista de peliculas disponibles
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 400.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(movieList) { movie ->
                // Tarjeta con la informacion de cada pelicula
                MovieCardInfo(
                    movie = movie,
                    navController = navController,
                )
            }
        }
    }
}