package com.example.vacunas.data.source.local

import com.example.data.source.UserLocalDataSource
import com.example.data.utils.Response
import com.example.vacunas.data.source.local.room.daos.UserDao
import com.example.vacunas.data.source.local.room.model.toDomainUser
import com.example.vacunas.data.source.local.room.model.toRoomUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject
import com.example.domain.User as DomainUser
import com.example.vacunas.data.source.local.room.model.User as RoomUser

class UserRoomDataSource : UserLocalDataSource, KoinComponent {

    private val userDao: UserDao by inject()

    override suspend fun getUserList(): Response<List<DomainUser>> {
        return withContext(Dispatchers.IO) {
            try {
                Response.Success(userDao.getAll().map(RoomUser::toDomainUser))
            } catch (e: Exception) {
                Response.Error<List<DomainUser>>(e.message ?: "unknown")
            }
        }
    }

    override suspend fun findUserById(id: Int): Response<DomainUser> {
        return withContext(Dispatchers.IO) {
            try {
                Response.Success(userDao.findById(id).toDomainUser())
            } catch (e: Exception) {
                Response.Error<DomainUser>(e.message ?: "unknown")
            }
        }
    }

    override suspend fun insertUser(user: DomainUser): Response<Long> {
        return withContext(Dispatchers.IO) {
            try {
                Response.Success(userDao.insert(user.toRoomUser()))
            } catch (e: Exception) {
                Response.Error<Long>(e.message ?: "unknown")
            }
        }
    }
}