package com.example.kotlinlab1.domain.usecases

import com.example.kotlinlab1.domain.repository.UserInfoRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val repository : UserInfoRepository
) {
    suspend fun execute() = repository.getList()
}