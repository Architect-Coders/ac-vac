package com.example.vacunas.data.source.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VaccineNoteResponse(
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("text")
    @Expose
    val text: String
)