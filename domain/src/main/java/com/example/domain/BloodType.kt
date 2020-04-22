package com.example.domain

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
}