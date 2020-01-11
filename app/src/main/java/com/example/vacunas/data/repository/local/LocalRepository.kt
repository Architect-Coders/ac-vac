package com.example.vacunas.data.repository.local


import com.example.vacunas.data.model.User
import com.example.vacunas.data.repository.LocalRepositoryInterface
import com.example.vacunas.data.repository.local.db.AppDatabase
import com.example.vacunas.data.repository.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class LocalRepository : LocalRepositoryInterface, KoinComponent {

    private val db: AppDatabase by inject()

    override suspend fun getUserList(): Response<List<User>> {
        return withContext(Dispatchers.IO) {
            try {
                Response.Success(db.userDao().getAll())
            } catch (e: Exception) {
                Response.Error<List<User>>(e.message ?: "unknown")
            }
        }
    }

    override suspend fun insertUser(user: User): Response<Long> {
        return withContext(Dispatchers.IO) {
            try {
                Response.Success(db.userDao().insert(user))
            } catch (e: Exception) {
                Response.Error<Long>(e.message ?: "unknown")
            }
        }
    }
}