package com.example.movietest.data.sources.dto

import com.google.gson.annotations.SerializedName

// Clase que guarda los datos de la api/json
data class MovieDTO(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<Result>,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int
)