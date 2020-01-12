package com.example.vacunas.data.repository.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VaccineResponse(
    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("age")
    @Expose
    val age: String,

    @SerializedName("monthsSinceBirthdate")
    @Expose
    val monthsSinceBirthdate: Long
)