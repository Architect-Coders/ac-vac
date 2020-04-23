package com.example.data.source

import com.example.data.utils.Response
import com.example.domain.SpainRegion
import com.example.domain.VaccineCalendar

interface VaccineDataSource

interface VaccineLocalDataSource : VaccineDataSource

interface VaccineRemoteDataSource : VaccineDataSource {
    fun getVaccineCalendar(spainRegion: SpainRegion): Response<VaccineCalendar>
}