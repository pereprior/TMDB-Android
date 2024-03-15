package com.example.movietest.data.api.dto

import com.google.gson.annotations.SerializedName

data class GenresDTO(
    @SerializedName("genres")
    val genres: List<GenreResult> = emptyList()
)