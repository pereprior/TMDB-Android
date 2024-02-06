package com.example.movietest.data.mappers

import com.example.movietest.domain.models.Movie

interface IDataMapper {
    fun convert(): List<Movie>
}