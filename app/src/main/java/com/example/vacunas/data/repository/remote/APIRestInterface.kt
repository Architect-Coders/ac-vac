package com.example.vacunas.data.repository.remote

import com.example.vacunas.data.model.SpainRegion
import com.example.vacunas.data.repository.remote.model.VaccineCalendarResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIRestInterface {

    @GET("/{region}")
    suspend fun getVaccineCalendar(@Path("region")region: SpainRegion): Response<VaccineCalendarResponse>
}