package com.example.movietest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietest.data.repositories.MovieRoomRepository
import com.example.movietest.domain.models.Movie
import kotlinx.coroutines.launch

// Gestionar las peliculas que guardamos en favoritos
class RoomViewModel(
    private val repository: MovieRoomRepository
): ViewModel() {

    private var _favoriteMoviesList = MutableLiveData<MutableList<Movie>>()
    val favoriteMoviesList: LiveData<MutableList<Movie>> = _favoriteMoviesList

    fun saveMovie(movie: Movie) {
        viewModelScope.launch {
            movie.favorite = true
            repository.insertMovie(movie)
            _favoriteMoviesList.value?.add(movie)
        }
    }

    fun removeMovie(movie: Movie) {
        viewModelScope.launch {
            movie.favorite = false
            repository.removeMovie(movie)
            _favoriteMoviesList.value?.remove(movie)
        }
    }
}