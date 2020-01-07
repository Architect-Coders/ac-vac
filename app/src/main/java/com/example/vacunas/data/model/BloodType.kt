package com.example.vacunas.data.model

import androidx.room.TypeConverter

enum class BloodType(val refValue: Int) {
    UNKNWON(-1),
    A_POS(1), A_NEG(2),
    B_POS(3), B_NEG(4),
    AB_POS(5), AB_NEG(6),
    ZERO_POS(7), ZERO_NEG(8);

    internal class Converters {
        @TypeConverter
        fun toBloodType(bloodType: Int): BloodType {
            return UNKNWON
        }

        @TypeConverter
        fun fromBloodType(bloodType: BloodType): Int {
            return 0
        }
    }
}