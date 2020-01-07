package com.example.vacunas.data.model

import androidx.room.*

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Int = -1,

    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "birthdate")
    val birthDate: Long = -1L,

    @ColumnInfo(name = "bloodType")
    @TypeConverters(BloodType.Converters::class)
    val bloodType: BloodType = BloodType.UNKNWON,

    @ColumnInfo(name = "region")
    @TypeConverters(SpainRegion.Converters::class)
    val region: SpainRegion = SpainRegion.UNKNWON
)