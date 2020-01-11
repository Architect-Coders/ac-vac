package com.example.vacunas.data.repository

import com.example.vacunas.data.model.User
import com.example.vacunas.data.repository.local.LocalRepository
import com.example.vacunas.data.repository.remote.RemoteRepository
import com.example.vacunas.data.repository.utils.Response
import com.example.vacunas.helpers.ConnectionHelper
import org.koin.core.KoinComponent
import org.koin.core.inject


class RepositoryFactory(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) : KoinComponent {
    val connectionHelper: ConnectionHelper by inject()

    suspend fun getUserList(): Response<List<User>> {
        return localRepository.getUserList()
    }

    suspend fun saveUser(user: User): Response<Long> {
        return localRepository.insertUser(user)
    }
}

interface RepositoryInterface {
    suspend fun getUserList(): Response<List<User>>
}

interface LocalRepositoryInterface : RepositoryInterface {
    suspend fun insertUser(user: User): Response<Long>
}

