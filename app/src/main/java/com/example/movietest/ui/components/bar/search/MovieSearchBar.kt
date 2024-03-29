package com.example.movietest.ui.components.bar.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movietest.R
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.utils.TOP_BAR_PADDING_VALUE
import com.example.movietest.ui.screens.movies.list.view.MoviesListView
import com.example.movietest.ui.viewmodels.SearchBarViewModel

// Barra de busqueda de datos
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MovieSearchBar(
    query: String,
    searchBarViewModel: SearchBarViewModel,
    filteredDataList: List<Movie>,
    navController: NavHostController,
    route: String
) {
    SearchBar(
        query = query,
        onQueryChange = { searchBarViewModel.setQuery(it) },
        onSearch = {
            // Comprobamos que en la lista existe una pelicula igual que el que ha buscado el usuario
            if (filteredDataList.any { it.title.equals(query, ignoreCase = true) }) {
                // Con lowercase, el usuario puede buscar con mayusculas y minusculas como quiera
                navController.navigate("$route/${query.lowercase()}")
            } else {
                searchBarViewModel.setOpenDialog(true)
            }
        },
        active = true,
        onActiveChange = {},
        leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon") },
        placeholder = {
            Text(
                text = stringResource(id = R.string.searchbar_placeholder),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        content = {
            // Muestra la lista de peliculas conforme a la busqueda del usuario
            MoviesListView(
                movieList = filteredDataList,
                navController = navController
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(top = TOP_BAR_PADDING_VALUE.dp),
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.background,
            dividerColor = MaterialTheme.colorScheme.onBackground
        )
    )
}