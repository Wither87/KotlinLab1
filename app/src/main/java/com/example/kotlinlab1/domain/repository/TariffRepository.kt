package com.example.kotlinlab1.domain.repository

import com.example.kotlinlab1.data.models.Tariff

interface TariffRepository {
    suspend fun getList() : List<Tariff>
}