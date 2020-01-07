package com.example.vacunas.data.repository.local.bbdd

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.vacunas.data.model.BloodType
import com.example.vacunas.data.model.SpainRegion
import com.example.vacunas.data.model.User
import com.example.vacunas.data.repository.local.bbdd.dao.UserDao

@Database(entities = [User::class], version = 1)
@TypeConverters(BloodType.Converters::class, SpainRegion.Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}