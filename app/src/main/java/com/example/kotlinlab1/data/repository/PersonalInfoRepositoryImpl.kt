package com.example.kotlinlab1.data.repository

import com.example.kotlinlab1.data.api.RetrofitService
import com.example.kotlinlab1.domain.repository.PersonalInfoRepository
import javax.inject.Inject

class PersonalInfoRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : PersonalInfoRepository {
    override suspend fun get(id: Int) = retrofitService.getPersonalInfo(id)
}