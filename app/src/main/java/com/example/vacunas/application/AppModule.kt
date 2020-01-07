package com.example.vacunas.application

import android.content.Context
import androidx.room.Room
import com.example.vacunas.BuildConfig
import com.example.vacunas.data.repository.local.bbdd.AppDatabase
import com.example.vacunas.helpers.AndroidResourceHelper
import com.example.vacunas.ui.blank.BlankViewModel
import com.example.vacunas.ui.main.viewmodel.MainViewModel
import com.example.vacunas.ui.splash.viewmodel.SplashViewModel
import com.example.vacunas.ui.user.editing.UserEditingViewModel
import com.example.vacunas.ui.user.list.UserListViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Provide Singletons
    single { AndroidResourceHelper(get()) }
    single { provideGson() }
    single { provideRoom(get()) }

    // Provide Repositories

    // Provide ViewModels
    viewModel { MainViewModel() }
    viewModel { SplashViewModel() }
    viewModel { UserListViewModel() }
    viewModel { UserEditingViewModel() }
    viewModel { BlankViewModel() }
}

fun provideGson(): Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

fun provideRoom(context: Context): AppDatabase =
    Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.DATABASE_NAME).build()
