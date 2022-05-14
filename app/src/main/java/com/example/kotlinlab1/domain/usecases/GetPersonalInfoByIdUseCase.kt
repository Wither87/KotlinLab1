package com.example.kotlinlab1.domain.usecases

import com.example.kotlinlab1.domain.repository.PersonalInfoRepository
import javax.inject.Inject

class GetPersonalInfoByIdUseCase @Inject constructor(
    private val repository: PersonalInfoRepository
) {
    suspend fun execute(id: Int) = repository.get(id)
}