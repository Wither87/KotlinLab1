package com.example.kotlinlab1.data.repository

import com.example.kotlinlab1.data.api.RetrofitService
import com.example.kotlinlab1.domain.repository.UserInfoRepository
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : UserInfoRepository {
    override suspend fun getList() = retrofitService.getUserInfoList()
}