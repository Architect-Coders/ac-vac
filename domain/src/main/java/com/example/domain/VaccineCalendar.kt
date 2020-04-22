package com.example.domain

import java.util.Collections.emptyList

data class VaccineCalendar(
    val vaccineList: List<Vaccine> = emptyList(),
    val notes: List<VaccineNote>?
)