package com.example.data.repository

import com.example.data.source.UserLocalDataSource
import com.example.data.utils.Response
import com.example.domain.User


class UserRepository(
    private val userLocalDataSource: UserLocalDataSource
) {

    suspend fun getUserList(): Response<List<User>> = userLocalDataSource.getUserList()

    suspend fun findUserById(id: Int): Response<User> = userLocalDataSource.findUserById(id)

    suspend fun saveUser(user: User): Response<Long> = userLocalDataSource.insertUser(user)
}

