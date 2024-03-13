package com.example.movietest.ui.screens.movies.list.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
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
import com.example.movietest.ui.components.constants.TOP_BAR_PADDING_VALUE
import com.example.movietest.ui.components.loading.LoadingText
import com.example.movietest.ui.theme.typography
import com.example.movietest.ui.viewmodels.SearchBarViewModel
import kotlinx.coroutines.delay

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MovieSearchBar(
    query: String,
    searchBarViewModel: SearchBarViewModel,
    filteredDataList: List<Movie>,
    navController: NavHostController,
    route: String,
) {
    SearchBar(
        query = query,
        onQueryChange = {
            searchBarViewModel.setQuery(it)
        },
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
        leadingIcon = {
            Icon(imageVector = Icons.Filled.List, contentDescription = "Menu Icon")
        },
        placeholder = {
            Text(text = stringResource(id = R.string.searchbar_placeholder))
        },
        trailingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon")
        },
        content = {
            DataList(filteredDataList, navController)
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(top = TOP_BAR_PADDING_VALUE.dp),
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.background,
            dividerColor = MaterialTheme.colorScheme.background
        )
    )
}

@Composable
private fun DataList(
    filteredDataList: List<Movie>,
    navController: NavHostController
) {
    var showSearching by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = true) {
        delay(3000L)
        showSearching = false
    }

    if (filteredDataList.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MEDIUM_PADDING_VALUE.dp),
            contentAlignment = Alignment.Center
        ) {
            if (showSearching) {
                LoadingText(
                    message = stringResource(id = R.string.loading_description),
                    style = typography.titleLarge
                )
            } else {
                Text(
                    text = stringResource(id = R.string.no_results),
                    style = typography.titleLarge,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 400.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(filteredDataList) { movie ->
            MovieCardInfo(
                movie = movie,
                navController = navController
            )
        }
    }
}