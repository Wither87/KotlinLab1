package com.example.kotlinlab1.domain.repository

import com.example.kotlinlab1.data.models.PersonalInfo

interface PersonalInfoRepository {
    suspend fun get(id: Int) : PersonalInfo
}