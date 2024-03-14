package com.example.movietest.ui.screens.movies.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.movietest.ui.viewmodels.RoomViewModel

@Composable
fun FavoritesScreen(
    navController: NavHostController,
    roomViewModel: RoomViewModel
) {
    val favoritesList by roomViewModel.favoriteMoviesList.observeAsState(initial = emptyList())

    MoviesListView(
        movieList = favoritesList,
        navHostController = navController,
        roomViewModel = roomViewModel,
    )
}