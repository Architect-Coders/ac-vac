package com.example.vacunas.data.repository.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Collections.emptyList

data class VaccineCalendarResponse(
    @SerializedName("vaccines")
    @Expose
    val vaccineResponseList: List<VaccineResponse> = emptyList(),

    @SerializedName("notes")
    @Expose
    val notes: List<VaccineNoteResponse> = emptyList()
)