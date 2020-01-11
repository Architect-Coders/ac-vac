package com.example.vacunas.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "users")
data class User(
    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "birthdate")
    val birthDate: Long = -1L,

    @ColumnInfo(name = "bloodType")
    @TypeConverters(BloodType.Converters::class)
    val bloodType: BloodType = BloodType.UNKNOWN,

    @ColumnInfo(name = "region")
    @TypeConverters(SpainRegion.Converters::class)
    val region: SpainRegion = SpainRegion.UNKNOWN
) {
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0
}