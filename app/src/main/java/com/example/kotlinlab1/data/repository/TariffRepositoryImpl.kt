package com.example.kotlinlab1.data.repository

import com.example.kotlinlab1.data.api.RetrofitService
import com.example.kotlinlab1.domain.repository.TariffRepository
import javax.inject.Inject

class TariffRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : TariffRepository {
    override suspend fun getList() = retrofitService.getTariffList()
}