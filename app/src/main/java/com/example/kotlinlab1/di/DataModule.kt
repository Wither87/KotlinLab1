package com.example.kotlinlab1.di

import com.example.kotlinlab1.data.api.RetrofitService
import com.example.kotlinlab1.data.repository.PersonalInfoRepositoryImpl
import com.example.kotlinlab1.data.repository.TariffRepositoryImpl
import com.example.kotlinlab1.data.repository.UserInfoRepositoryImpl
import com.example.kotlinlab1.domain.repository.PersonalInfoRepository
import com.example.kotlinlab1.domain.repository.TariffRepository
import com.example.kotlinlab1.domain.repository.UserInfoRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideTariffRepository(retrofitService: RetrofitService) : TariffRepository {
        return TariffRepositoryImpl(retrofitService = retrofitService)
    }

    @Provides
    fun providePersonalInfoRepository(retrofitService: RetrofitService) : PersonalInfoRepository {
        return PersonalInfoRepositoryImpl(retrofitService = retrofitService)
    }

    @Provides
    fun provideUserInfoRepository(retrofitService: RetrofitService) : UserInfoRepository {
        return UserInfoRepositoryImpl(retrofitService = retrofitService)
    }
}