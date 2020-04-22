package com.example.domain


data class User(
    val name: String = "",
    val birthDate: Long = -1L,
    val bloodType: BloodType = BloodType.UNKNOWN,
    val region: SpainRegion = SpainRegion.UNKNOWN
) {
    var userId: Int = 0
}