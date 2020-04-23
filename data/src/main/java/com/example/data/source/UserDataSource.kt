package com.example.data.source

import com.example.data.utils.Response
import com.example.domain.User

interface UserDataSource

interface UserLocalDataSource : UserDataSource {
    suspend fun getUserList(): Response<List<User>>
    suspend fun findUserById(id: Int): Response<User>
    suspend fun insertUser(user: User): Response<Long>
}

interface UserRemoteDataSource : UserDataSource