package com.example.kotlinlab1.di

import dagger.Module

@Module(includes = [
    DataModule::class,
    DomainModule::class,
    NetworkModule::class,
    ViewModelModule::class,
])
class AppModule