package com.example.kotlinlab1.data.api

import com.example.kotlinlab1.data.models.PersonalInfo
import com.example.kotlinlab1.data.models.Tariff
import com.example.kotlinlab1.data.models.UserInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("tariffs")
    suspend fun getTariffList(): List<Tariff>

    @GET("userinfo")
    suspend fun getUserInfoList(): List<UserInfo>

    @GET("personalityinfo/{id}")
    suspend fun getPersonalInfo(@Path("id") id: Int): PersonalInfo
}
