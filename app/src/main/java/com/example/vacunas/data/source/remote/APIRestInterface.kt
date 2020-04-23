package com.example.vacunas.data.source.remote

import com.example.domain.SpainRegion
import com.example.vacunas.data.source.remote.model.VaccineCalendarResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIRestInterface {

    @GET("/{region}")
    suspend fun getVaccineCalendar(@Path("region")region: SpainRegion): Response<VaccineCalendarResponse>
}