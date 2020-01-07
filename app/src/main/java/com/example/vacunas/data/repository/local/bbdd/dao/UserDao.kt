package com.example.vacunas.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.vacunas.data.model.User

interface UserDAO {
    @Query("SELECT * FROM users")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE userId == userId")
    suspend fun findByName(userId: Int): User

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}