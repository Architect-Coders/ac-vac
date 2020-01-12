package com.example.vacunas.data.repository

import com.example.vacunas.data.model.SpainRegion
import com.example.vacunas.data.model.User
import com.example.vacunas.data.model.VaccineCalendar
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

    suspend fun getUserList(): Response<List<User>> = localRepository.getUserList()

    suspend fun findUserById(id: Int): Response<User> = localRepository.findUserById(id)

    suspend fun saveUser(user: User): Response<Long> = localRepository.insertUser(user)

    suspend fun getVaccineCalendar(spainRegion: SpainRegion): Response<VaccineCalendar> {
        return remoteRepository.getVaccineCalendar(spainRegion)
    }
}

interface RepositoryInterface

interface LocalRepositoryInterface : RepositoryInterface {
    suspend fun getUserList(): Response<List<User>>
    suspend fun findUserById(id: Int): Response<User>
    suspend fun insertUser(user: User): Response<Long>
}

interface RemoteRepositoryInterface : RepositoryInterface {
    suspend fun getVaccineCalendar(spainRegion: SpainRegion): Response<VaccineCalendar>
}

