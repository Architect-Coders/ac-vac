package com.example.vacunas.data.repository.remote.model

import com.example.vacunas.data.repository.remote.model.VaccineResponse
import com.example.vacunas.data.repository.remote.model.VaccineNoteResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VaccineCalendarResponse(
    @SerializedName("vaccines")
    @Expose
    val vaccineResponseList: List<VaccineResponse> = emptyList(),

    @SerializedName("notes")
    @Expose
    val notes: List<VaccineNoteResponse> = emptyList()
)