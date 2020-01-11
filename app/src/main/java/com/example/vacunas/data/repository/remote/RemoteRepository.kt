package com.example.vacunas.data.repository.remote

import com.example.vacunas.data.model.User
import com.example.vacunas.data.repository.RepositoryInterface
import com.example.vacunas.data.repository.utils.Response

class RemoteRepository : RepositoryInterface {
    override suspend fun getUserList(): Response<List<User>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}