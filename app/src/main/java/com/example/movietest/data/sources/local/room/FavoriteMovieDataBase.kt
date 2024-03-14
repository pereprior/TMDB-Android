package com.example.movietest.data.sources.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class FavoriteMovieDataBase: RoomDatabase() {
    abstract val dao: MovieDAO
}