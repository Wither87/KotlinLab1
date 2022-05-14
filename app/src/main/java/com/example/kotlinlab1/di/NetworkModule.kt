package com.example.kotlinlab1.di

import com.example.kotlinlab1.data.api.RetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun provideRetrofitService(): RetrofitService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://62650d1d94374a2c506c92ce.mockapi.io/api/v1/")
            .build()
        return retrofit.create()
    }
}