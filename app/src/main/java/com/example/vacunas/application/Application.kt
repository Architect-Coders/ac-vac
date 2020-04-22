package com.example.vacunas.application

import android.app.Application

@Suppress("unused")
class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        // Dependencies injection
        initKoin()
    }
}
