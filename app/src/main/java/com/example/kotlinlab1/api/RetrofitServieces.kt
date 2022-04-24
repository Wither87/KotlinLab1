package com.example.kotlinlab1.api

import com.example.kotlinlab1.data.PersonalInfo
import com.example.kotlinlab1.data.Tariff
import com.example.kotlinlab1.data.UserInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitServieces {
    @GET("tariffs")
    fun getTariffList(): Call<List<Tariff>>

    @GET("userinfo")
    fun getUserInfoList(): Call<List<UserInfo>>

    @GET("personalityinfo/{id}")
    fun getPersonalInfo(@Path("id") id: Int): Call<PersonalInfo>
}
