package com.example.movietest.data.sources.dto

import com.google.gson.annotations.SerializedName

data class GenreResult(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String
)