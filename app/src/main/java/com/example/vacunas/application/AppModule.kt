package com.example.vacunas.application

import android.content.Context
import androidx.room.Room
import com.example.vacunas.BuildConfig
import com.example.vacunas.data.repository.RepositoryFactory
import com.example.vacunas.data.repository.local.LocalRepository
import com.example.vacunas.data.repository.local.db.AppDatabase
import com.example.vacunas.data.repository.remote.APIRestInterface
import com.example.vacunas.data.repository.remote.RemoteRepository
import com.example.vacunas.helpers.AndroidResourceHelper
import com.example.vacunas.helpers.ConnectionHelper
import com.example.vacunas.ui.blank.BlankViewModel
import com.example.vacunas.ui.detail.DetailViewModel
import com.example.vacunas.ui.main.viewmodel.MainViewModel
import com.example.vacunas.ui.splash.viewmodel.SplashViewModel
import com.example.vacunas.ui.user.editing.UserEditingViewModel
import com.example.vacunas.ui.user.list.UserListViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    // Provide Singletons
    single { AndroidResourceHelper(get()) }
    single { ConnectionHelper(get()) }
    single { provideGson() }
    single { provideRoom(get()) }

    // Provide Retrofit
    single { createOkHttpClient(get()) }
    single { createRetrofitClient<APIRestInterface>(get()) }

    // Provide Repositories
    single { LocalRepository() }
    single { RemoteRepository() }
    single { RepositoryFactory(get(), get()) }

    // Provide ViewModels
    viewModel { MainViewModel() }
    viewModel { SplashViewModel() }
    viewModel { UserListViewModel() }
    viewModel { UserEditingViewModel() }
    viewModel { (userId: Int) -> DetailViewModel(userId) }
    viewModel { BlankViewModel() }
}

fun provideGson(): Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

fun provideRoom(context: Context): AppDatabase =
    Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.DATABASE_NAME).build()

fun createOkHttpClient(context: Context): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(8L, TimeUnit.SECONDS)
        .callTimeout(8L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .build()
}

inline fun <reified T> createRetrofitClient(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.URL_API_REST)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}
