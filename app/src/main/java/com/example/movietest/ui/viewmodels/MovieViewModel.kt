package com.example.movietest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietest.domain.models.Movie
import com.example.movietest.domain.usecases.GetFavoritesUseCase
import com.example.movietest.domain.usecases.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// Gestionar las peliculas que obtenemos de la API
@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase
): ViewModel() {

    private var _movieList = MutableLiveData<List<Movie>>()
    private var _favoriteMoviesList = MutableLiveData<List<Movie>>()

    val movieList: LiveData<List<Movie>> = _movieList
    val favoriteMoviesList: LiveData<List<Movie>> = _favoriteMoviesList

    // Cargamos los datos de las peliculas en el momento en el que instanciamos el view model
    init {
        getMovies()
    }

    // Por defecto, se visualizara la lista de peliculas populares, pero se podrá cambiar el endpoint para obtener otras listas
    private fun getMovies() {
        viewModelScope.launch {
            _movieList.value = getMoviesUseCase.execute()
            _favoriteMoviesList.value = getFavoritesUseCase.execute()
        }
    }

    // Obtener una pelicula especifica a partir de su titulo
    fun getMovieByTitle(title: String): Movie? {
        return _movieList.value?.find { it.title == title }
    }

    // Añade una pelicula a la lista de favoritos
    fun saveMovie(movie: Movie) {
        viewModelScope.launch {
            getFavoritesUseCase.insert(movie)
            _favoriteMoviesList.value = getFavoritesUseCase.execute()
        }
    }

    // Elimina una pelicula de la lista de favoritos
    fun removeMovie(movie: Movie) {
        viewModelScope.launch {
            getFavoritesUseCase.delete(movie)
            _favoriteMoviesList.value = getFavoritesUseCase.execute()
        }
    }

    // Devuelve true si existe una pelicula con el titulo pasado por parametro
    fun isFavoriteByTitle(title: String): Boolean {
        return _favoriteMoviesList.value?.any { it.title == title } ?: false
    }
}