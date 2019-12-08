package com.example.vacunas.application

import com.example.vacunas.helpers.AndroidResourceHelper
import com.example.vacunas.ui.blank.BlankViewModel
import com.example.vacunas.ui.main.viewmodel.MainViewModel
import com.example.vacunas.ui.splash.viewmodel.SplashViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Provide Singletons
    single { AndroidResourceHelper(get()) }
    single { provideGson() }

    // Provide Repositories

    // Provide ViewModels
    viewModel { MainViewModel() }
    viewModel { SplashViewModel() }
    viewModel { BlankViewModel() }
}

fun provideGson(): Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
