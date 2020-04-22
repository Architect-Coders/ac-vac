package com.example.vacunas.data.repository.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.vacunas.data.repository.local.room.daos.UserDao
import com.example.vacunas.data.repository.local.room.model.User

@Database(entities = [User::class], version = 1)
@TypeConverters(User.Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}