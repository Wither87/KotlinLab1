package com.example.kotlinlab1.domain.usecases

import com.example.kotlinlab1.domain.repository.TariffRepository
import javax.inject.Inject

class GetTariffsUseCase @Inject constructor(
    private val repository: TariffRepository
) {
    suspend fun execute() = repository.getList()
}