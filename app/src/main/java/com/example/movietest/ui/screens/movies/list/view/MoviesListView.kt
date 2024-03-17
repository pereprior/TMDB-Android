package com.example.movietest.ui.screens.movies.list.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movietest.ui.components.utils.TOP_BAR_PADDING_VALUE
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.error.NotFoundMessage

// Contenido con la lista de las peliculas disponibles
@Composable
fun MoviesListView(
    movieList: List<Movie>,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    if (movieList.isEmpty()) {
        // Muetsra un mensaje si no se encuentran resultados
        NotFoundMessage()
    } else {
        // Muestra la lista de peliculas disponibles
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 400.dp),
            modifier = modifier.fillMaxSize()
        ) {
            items(movieList) { movie ->
                // Tarjeta con la informacion de cada pelicula
                MovieCardInfo(
                    movie = movie,
                    navController = navController,
                )
            }

            item {
                Spacer(modifier = Modifier.size(TOP_BAR_PADDING_VALUE.dp))
            }
        }
    }
}