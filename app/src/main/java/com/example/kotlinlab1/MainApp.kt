package com.example.kotlinlab1

import android.app.Application
import android.content.Context
import com.example.kotlinlab1.di.AppComponent
import com.example.kotlinlab1.di.AppModule
import com.example.kotlinlab1.di.DaggerAppComponent

class MainApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> applicationContext.appComponent
    }
