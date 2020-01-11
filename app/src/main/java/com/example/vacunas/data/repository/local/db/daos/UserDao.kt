package com.example.vacunas.data.repository.local.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.vacunas.data.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE userId == :userId")
    suspend fun findByName(userId: Int): User

    @Insert
    suspend fun insert(user: User): Long

    @Delete
    suspend fun delete(user: User)
}