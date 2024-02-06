package com.example.movietest.ui.screens.list.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.error.ERROR_404_DESCRIPTION
import com.example.movietest.ui.components.error.ERROR_404_TITLE
import com.example.movietest.ui.components.error.dialog.NotFoundDialog
import com.example.movietest.ui.viewmodels.SearchBarViewModel

@Composable
fun SearchBarScreen(
    navController: NavHostController,
    movieList: List<Movie>,
    route: String
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
    )

    // Si el usuario busca una pelicula que no existe, saldra un mensaje de error
    if (isOpenDialog) {
        NotFoundDialog(
            onDismissRequest = { searchBarViewModel.setOpenDialog(false) },
            title = ERROR_404_TITLE,
            description = ERROR_404_DESCRIPTION
        )
    }
}