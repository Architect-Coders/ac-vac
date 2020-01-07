package com.example.vacunas.data.model

import androidx.room.TypeConverter

enum class BloodType(val refValue: Int) {
    UNKNOWN(BloodType.CONST_UNKNOWN),
    A_POS(BloodType.CONST_A_POS), A_NEG(BloodType.CONST_A_NEG),
    B_POS(BloodType.CONST_B_POS), B_NEG(BloodType.CONST_B_NEG),
    AB_POS(BloodType.CONST_AB_POS), AB_NEG(BloodType.CONST_AB_NEG),
    ZERO_POS(BloodType.CONST_ZERO_POS), ZERO_NEG(BloodType.CONST_ZERO_NEG);

    companion object {
        const val CONST_UNKNOWN = -1
        const val CONST_A_POS = 0
        const val CONST_A_NEG = 1
        const val CONST_B_POS = 2
        const val CONST_B_NEG = 3
        const val CONST_AB_POS = 4
        const val CONST_AB_NEG = 5
        const val CONST_ZERO_POS = 6
        const val CONST_ZERO_NEG = 7
    }

    internal class Converters {
        @TypeConverter
        fun toBloodType(bloodType: Int): BloodType {
            return when (bloodType) {
                CONST_A_POS -> A_POS
                CONST_A_NEG -> A_NEG
                CONST_B_POS -> B_POS
                CONST_B_NEG -> B_NEG
                CONST_AB_POS -> AB_POS
                CONST_AB_NEG -> AB_NEG
                CONST_ZERO_POS -> ZERO_POS
                CONST_ZERO_NEG -> ZERO_NEG
                else -> UNKNOWN
            }
        }

        @TypeConverter
        fun fromBloodType(bloodType: BloodType): Int = bloodType.refValue
    }
}