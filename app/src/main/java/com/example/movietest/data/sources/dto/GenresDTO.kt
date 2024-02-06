package com.example.movietest.data.sources.dto

import com.google.gson.annotations.SerializedName

data class GenresDTO(
    @SerializedName("genres")
    val genres: List<GenreResult> = emptyList()
)