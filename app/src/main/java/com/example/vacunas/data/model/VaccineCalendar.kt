package com.example.vacunas.data.model

import com.example.vacunas.data.repository.remote.model.VaccineNoteResponse
import com.example.vacunas.data.repository.remote.model.VaccineResponse

data class VaccineCalendar(
    val vaccineResponseList: List<VaccineResponse> = emptyList(),
    val notes: List<VaccineNoteResponse>?
)