package com.example.vacunas.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        // Dependencies injection
        startKoin {
            androidContext(this@Application)
            modules(listOf(appModule))
        }
    }
}
