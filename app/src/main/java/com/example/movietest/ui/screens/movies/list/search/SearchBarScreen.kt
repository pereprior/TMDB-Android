package com.example.movietest.ui.screens.movies.list.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.movietest.R
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.error.dialog.NotFoundDialog
import com.example.movietest.ui.viewmodels.RoomViewModel
import com.example.movietest.ui.viewmodels.SearchBarViewModel

@Composable
fun SearchBarScreen(
    navController: NavHostController,
    movieList: List<Movie>,
    route: String = "",
    roomViewModel: RoomViewModel
) {
    val searchBarViewModel = SearchBarViewModel()
    val query: String by searchBarViewModel.query.observeAsState(initial = "")
    val filteredData: List<Movie> by searchBarViewModel.filteredList.observeAsState(initial = emptyList())
    val isOpenDialog: Boolean by searchBarViewModel.openDialog.observeAsState(initial = false)

    searchBarViewModel.setDataList(movieList, query)

    // Pantalla principal que muestra el listado de peliculas
    MovieSearchBar(
        query = query,
        searchBarViewModel = searchBarViewModel,
        filteredDataList = filteredData,
        navController = navController,
        route = route,
        roomViewModel = roomViewModel
    )

    // Si el usuario busca una pelicula que no existe, saldra un mensaje de error
    if (isOpenDialog) {
        NotFoundDialog(
            onDismissRequest = { searchBarViewModel.setOpenDialog(false) },
            title = stringResource(id = R.string.error_404_title),
            description = stringResource(id = R.string.error_404_description)
        )
    }
}