package com.example.movietest.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietest.domain.models.Movie

class SearchBarViewModel: ViewModel() {

    private var _query = MutableLiveData<String>()
    private var _filteredList = MutableLiveData<List<Movie>>()
    private var _openDialog = MutableLiveData<Boolean>()

    val query: LiveData<String> = _query
    val filteredList: LiveData<List<Movie>> = _filteredList
    val openDialog: LiveData<Boolean> = _openDialog

    // Actualizar el texto que introduce el usuario en la barra de busqueda
    fun setQuery(value: String) {
        _query.value = value
    }

    // Filtrar la lista de peliculas de acuerdo al texto que esté introduciendo el usuario
    fun setDataList(values: List<Movie>, query: String) {
        val data = values.map { it }
        _filteredList.value = data.filter { it.title.contains(query, true) }
    }

    // Abrir un mensaje de error en caso que el texto introducido no coincida con ninguna pelicula existente
    fun setOpenDialog(value: Boolean) {
        _openDialog.value = value
    }

}