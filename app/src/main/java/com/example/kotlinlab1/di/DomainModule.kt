package com.example.kotlinlab1.di

import com.example.kotlinlab1.domain.usecases.GetPersonalInfoByIdUseCase
import com.example.kotlinlab1.domain.usecases.GetTariffsUseCase
import com.example.kotlinlab1.domain.usecases.GetUserInfoUseCase
import com.example.kotlinlab1.domain.repository.PersonalInfoRepository
import com.example.kotlinlab1.domain.repository.TariffRepository
import com.example.kotlinlab1.domain.repository.UserInfoRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetPersonalInfoByIdUseCase(repository: PersonalInfoRepository) : GetPersonalInfoByIdUseCase{
        return GetPersonalInfoByIdUseCase(repository=repository)
    }

    @Provides
    fun provideGetTariffsUseCase(repository: TariffRepository) : GetTariffsUseCase {
        return GetTariffsUseCase(repository=repository)
    }

    @Provides
    fun provideGetUserInfoUseCase(repository: UserInfoRepository) : GetUserInfoUseCase {
        return GetUserInfoUseCase(repository=repository)
    }
}