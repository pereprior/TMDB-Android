package com.example.movietest.domain.di

import android.content.Context
import androidx.room.Room
import com.example.movietest.data.db.FavoritesDataBase
import com.example.movietest.data.db.dao.MovieDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "movie_database"

    @Singleton
    @Provides
    fun provideRoomModule(@ApplicationContext context: Context): FavoritesDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = FavoritesDataBase::class.java,
            name = DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(db: FavoritesDataBase): MovieDAO {
        return db.getMovieDao()
    }

}