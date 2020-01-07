package com.example.vacunas.data.model

import androidx.room.TypeConverter

enum class SpainRegion(val refValue: String) {
    UNKNWON("Unknown"),
    ANDALUCIA("Andalucía"),
    ARAGON("Aragón"),
    ASTURIAS("Asturias"),
    CANTABRIA("Cantabria");

    internal class Converters {
        @TypeConverter
        fun toSpainRegion(spainRegion: String): SpainRegion {
            return UNKNWON
        }

        @TypeConverter
        fun fromSpainRegion(spainRegion: SpainRegion): String {
            return ""
        }
    }
}