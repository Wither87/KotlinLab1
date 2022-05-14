package com.example.kotlinlab1.domain.repository

import com.example.kotlinlab1.data.models.UserInfo

interface UserInfoRepository {
    suspend fun getList(): List<UserInfo>
}