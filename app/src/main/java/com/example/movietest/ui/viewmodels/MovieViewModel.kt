package com.example.movietest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietest.domain.models.Movie
import com.example.movietest.domain.usecases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
): ViewModel() {

    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _movieList

    // Cargamos los datos de las peliculas en el momento en el que instanciamos el view model
    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            _movieList.value = getMovieListUseCase.execute()
        }
    }

    // Obtener una pelicula especifica a partir de su titulo
    fun getMovieByTitle(title: String): Movie? {
        return _movieList.value?.find { it.title == title }
    }
}