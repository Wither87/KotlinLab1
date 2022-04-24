package com.example.kotlinlab1.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofitService: RetrofitServieces
        get() = RetrofitClient.getClient().create(RetrofitServieces::class.java)

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://62650d1d94374a2c506c92ce.mockapi.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}
