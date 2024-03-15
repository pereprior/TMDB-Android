package com.example.movietest.domain.di

import android.app.Application
import com.example.movietest.constants.API_URL
import com.example.movietest.data.MovieRepository
import com.example.movietest.data.sources.MovieFallbackDataSource
import com.example.movietest.data.api.IApiService
import com.example.movietest.data.db.dao.MovieDAO
import com.example.movietest.data.sources.MovieRemoteDataSource
import com.example.movietest.data.sources.MovieRoomDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    // proporciona la instancia de la api medinate inyeccion de dependencias
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

    // proporciona la instancia del repositorio mediante inyeccion de dependencias
    @Provides
    @Singleton
    fun provideRepository(
        api: IApiService,
        application: Application,
        dao: MovieDAO
    ): MovieRepository {
        return MovieRepository(
            MovieRemoteDataSource(api),
            MovieFallbackDataSource(application),
            MovieRoomDataSource(dao)
        )
    }
}