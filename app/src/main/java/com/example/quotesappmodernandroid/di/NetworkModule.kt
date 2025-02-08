package com.example.quotesappmodernandroid.di

import com.example.quotesappmodernandroid.data.remote.ApiInterface
import com.example.quotesappmodernandroid.network.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    @Named("BaseUrl")
    fun getBaseUrl(): String = BASE_URL



    @Singleton
    @Provides
    fun getRetrofitClient( @Named("BaseUrl") baseUrl:String):Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        @Singleton
        @Provides
        fun getApiClient(retrofit: Retrofit):ApiInterface =
            retrofit.create(ApiInterface::class.java)
}