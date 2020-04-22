package com.example.data

import com.example.data.utils.Response
import com.example.domain.User
import org.koin.core.KoinComponent
import org.koin.core.inject


class UserRepository : KoinComponent {
    val userLocalDataSource: UserLocalDataSource by inject()

    suspend fun getUserList(): Response<List<User>> = userLocalDataSource.getUserList()

    suspend fun findUserById(id: Int): Response<User> = userLocalDataSource.findUserById(id)

    suspend fun saveUser(user: User): Response<Long> = userLocalDataSource.insertUser(user)
}

interface UserDataSource

interface UserLocalDataSource : UserDataSource {
    suspend fun getUserList(): Response<List<User>>
    suspend fun findUserById(id: Int): Response<User>
    suspend fun insertUser(user: User): Response<Long>
}

interface UserRemoteDataSource : UserDataSource

