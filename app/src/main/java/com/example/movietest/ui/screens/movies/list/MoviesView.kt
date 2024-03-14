package com.example.movietest.ui.screens.movies.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movietest.R
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE
import com.example.movietest.ui.screens.movies.list.search.MovieCardInfo
import com.example.movietest.ui.theme.typography
import kotlinx.coroutines.delay

@Composable
fun MoviesListView(
    movieList: List<Movie>,
    navHostController: NavHostController
) {
    var showSearching by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = true) {
        delay(3000L)
        showSearching = false
    }

    if (movieList.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MEDIUM_PADDING_VALUE.dp),
            contentAlignment = Alignment.Center
        ) {
            if (showSearching) {
                CircularProgressIndicator()
            } else {
                Text(
                    text = stringResource(id = R.string.no_results),
                    style = typography.titleLarge,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }

    MovieListColumns(
        movieList = movieList,
        navController = navHostController
    )
}

@Composable
private fun MovieListColumns(
    movieList: List<Movie>,
    navController: NavHostController,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 400.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(movieList) { movie ->
            MovieCardInfo(
                movie = movie,
                navController = navController,
            )
        }
    }
}