package com.example.vacunas.application

import android.content.Context
import androidx.room.Room
import com.example.data.repository.UserRepository
import com.example.data.repository.VaccineRepository
import com.example.data.source.UserLocalDataSource
import com.example.vacunas.BuildConfig
import com.example.vacunas.data.source.local.UserRoomDataSource
import com.example.vacunas.data.source.local.room.AppDatabase
import com.example.vacunas.data.source.local.room.daos.UserDao
import com.example.vacunas.data.source.remote.APIRestInterface
import com.example.vacunas.data.source.remote.VaccineRetrofitDataSource
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
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun Application.initKoin() {
    startKoin {
        androidContext(this@initKoin)
        modules(listOf(appModule, useCasesModule, dataModule))
    }
}

val useCasesModule = module {

}

val dataModule = module {
    single { UserRepository(get()) }
    single { VaccineRepository(get()) }
}

val appModule = module {
    // Provide Helpers
    single { AndroidResourceHelper(get()) }
    single { ConnectionHelper(get()) }

    // Provide Remote Repository
    single { provideGson() }
    single { createOkHttpClient(get()) }
    single { createRetrofitClient<APIRestInterface>(get()) }

    // Provide Local Repository
    single { provideRoom(get()) }
    single { provideUserDAO(get()) }

    // Provide DataSources
    factory<UserLocalDataSource>() { UserRoomDataSource() }
    factory { VaccineRetrofitDataSource() }

    // Provide ViewModels
    viewModel { MainViewModel() }
    viewModel { SplashViewModel() }
    viewModel { UserListViewModel() }
    viewModel { UserEditingViewModel() }
    viewModel { (userId: Int) -> DetailViewModel(userId) }
    viewModel { BlankViewModel() }
}

fun provideGson(): Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

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

fun provideRoom(context: Context): AppDatabase =
    Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.DATABASE_NAME).build()

fun provideUserDAO(database: AppDatabase): UserDao = database.userDao()
