package com.engindkycc.rickandmortymvvm.di

import com.engindkycc.rickandmortymvvm.data.remote.ApiService
import com.engindkycc.rickandmortymvvm.domain.repository.LocationRepoInterface
import com.engindkycc.rickandmortymvvm.data.repository.LocationRepository
import com.engindkycc.rickandmortymvvm.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance() : ApiService =
        Retrofit.Builder()
            .baseUrl(provideBaseUrl())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService) : LocationRepoInterface {

        return  LocationRepository(apiService)
    }

}