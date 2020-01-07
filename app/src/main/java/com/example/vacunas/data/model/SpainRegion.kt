package com.example.vacunas.data.model

import androidx.room.TypeConverter

enum class SpainRegion(val refValue: String) {
    UNKNOWN(SpainRegion.CONST_UNKNOWN),
    ANDALUCIA(SpainRegion.CONST_ANDALUCIA),
    ARAGON(SpainRegion.CONST_ARAGON),
    ASTURIAS(SpainRegion.CONST_ASTURIAS),
    CANTABRIA(SpainRegion.CONST_CANTABRIA);

    companion object Values {
        const val CONST_UNKNOWN = "Unknown"
        const val CONST_ANDALUCIA = "Andalucia"
        const val CONST_ARAGON = "Aragon"
        const val CONST_ASTURIAS = "Asturias"
        const val CONST_CANTABRIA = "Cantabria"
    }

    internal class Converters {
        @TypeConverter
        fun toSpainRegion(spainRegion: String): SpainRegion = when (spainRegion) {
            CONST_ANDALUCIA -> ANDALUCIA
            CONST_ARAGON -> ARAGON
            CONST_ASTURIAS -> ASTURIAS
            CONST_CANTABRIA -> CANTABRIA
            else -> UNKNOWN
        }

        @TypeConverter
        fun fromSpainRegion(spainRegion: SpainRegion): String = spainRegion.refValue
    }
}