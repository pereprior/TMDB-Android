package com.example.movietest.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movietest.domain.models.Movie

// Clase de pelicula que maneja la base de datos
@Entity(tableName = "movies_table")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "image_reference")
    val imageReference: String,

    /*@ColumnInfo(name = "genres")
    val genres: List<String>,*/

    @ColumnInfo(name = "original_language")
    val originalLanguage: String,

    @ColumnInfo(name = "original_title")
    val originalTitle: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "poster_reference")
    val posterReference: String,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,

    @ColumnInfo(name = "vote_count")
    val voteCount: Int
)

fun MovieEntity.toDomain(): Movie {
    return Movie(
        imageReference = this.imageReference,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overview = this.overview,
        posterReference = this.posterReference,
        releaseDate = this.releaseDate,
        title = this.title,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}