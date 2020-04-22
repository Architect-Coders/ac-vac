package com.example.domain

enum class SpainRegion(val refValue: String) {
    UNKNOWN(SpainRegion.CONST_UNKNOWN),
    ANDALUCIA(SpainRegion.CONST_ANDALUCIA),
    ARAGON(SpainRegion.CONST_ARAGON),
    ASTURIAS(SpainRegion.CONST_ASTURIAS),
    CANTABRIA(SpainRegion.CONST_CANTABRIA);

    companion object {
        const val CONST_UNKNOWN = "Unknown"
        const val CONST_ANDALUCIA = "Andalucia"
        const val CONST_ARAGON = "Aragon"
        const val CONST_ASTURIAS = "Asturias"
        const val CONST_CANTABRIA = "Cantabria"
    }
}