package com.example.movietest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movietest.data.db.dao.MovieDAO
import com.example.movietest.data.db.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 2)
abstract class FavoritesDataBase: RoomDatabase() {
    abstract fun getMovieDao(): MovieDAO
}