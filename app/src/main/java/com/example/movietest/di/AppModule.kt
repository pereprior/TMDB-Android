package com.example.movietest.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.movietest.data.api.API_URL
import com.example.movietest.data.MovieRepository
import com.example.movietest.data.sources.MovieFallbackDataSource
import com.example.movietest.data.api.IApiService
import com.example.movietest.data.db.FavoritesDataBase
import com.example.movietest.data.db.dao.MovieDAO
import com.example.movietest.data.sources.MovieRemoteDataSource
import com.example.movietest.data.sources.MovieRoomDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val DATABASE_NAME = "movie_database"

    // proporciona la instancia del repositorio
    @Provides
    @Singleton
    fun provideRepository(
        application: Application,
        api: IApiService,
        dao: MovieDAO
    ): MovieRepository {
        return MovieRepository(
            MovieRemoteDataSource(api),
            MovieFallbackDataSource(application),
            MovieRoomDataSource(dao)
        )
    }

    // proporciona la instancia de la api
    @Provides
    @Singleton
    fun provideApi(): IApiService {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(IApiService::class.java)
    }

    // proporciona la instancia de la base de datos
    @Singleton
    @Provides
    fun provideRoomModule(@ApplicationContext context: Context): FavoritesDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = FavoritesDataBase::class.java,
            name = DATABASE_NAME
        )
            .build()
    }

    // proporciona la instancia del dao
    @Singleton
    @Provides
    fun provideMovieDao(db: FavoritesDataBase): MovieDAO {
        return db.getMovieDao()
    }
}