package com.example.movietest.domain.di

import android.app.Application
import com.example.movietest.data.constants.API_URL
import com.example.movietest.data.repositories.MovieRepositoryImpl
import com.example.movietest.data.sources.local.MovieJsonDataSource
import com.example.movietest.data.sources.remote.IApiService
import com.example.movietest.data.sources.remote.MovieRemoteDataSource
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
object DIModule {
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
        application: Application
    ): MovieRepositoryImpl {
        return MovieRepositoryImpl(
            MovieRemoteDataSource(api),
            MovieJsonDataSource(application)
        )
    }
}