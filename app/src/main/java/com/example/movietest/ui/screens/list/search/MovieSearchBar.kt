package com.example.movietest.ui.screens.list.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movietest.R
import com.example.movietest.domain.models.Movie
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE
import com.example.movietest.ui.theme.typography
import com.example.movietest.ui.viewmodels.SearchBarViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MovieSearchBar(
    query: String,
    searchBarViewModel: SearchBarViewModel,
    filteredDataList: List<Movie>,
    navController: NavHostController,
    route: String,
) {
    val active: Boolean by searchBarViewModel.isActive.observeAsState(initial = true)

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
                searchBarViewModel.setActive(false)
            } else {
                searchBarViewModel.setOpenDialog(true)
            }
        },
        active = active,
        onActiveChange = {
            searchBarViewModel.setActive(it)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.List, contentDescription = "Menu Icon")
        },
        placeholder = {
            Text(text = stringResource(id = R.string.searchbar_placeholder))
        },
        trailingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon")
        }
    ) {
        LazyColumn(
            content = {
                items(filteredDataList) {
                    MovieCardInfo(
                        movie = it,
                        navController = navController
                    )
                }

                if (filteredDataList.isEmpty()) {
                    item {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = MEDIUM_PADDING_VALUE.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = stringResource(id = R.string.no_results),
                                style = typography.titleLarge,
                                fontStyle = FontStyle.Italic
                            )
                        }
                    }
                }
            }
        )
    }
}