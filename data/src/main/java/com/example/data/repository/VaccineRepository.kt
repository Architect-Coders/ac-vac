package com.example.data.repository

import com.example.data.source.VaccineRemoteDataSource
import com.example.data.utils.Response
import com.example.domain.SpainRegion
import com.example.domain.VaccineCalendar


class VaccineRepository(
    val vaccineRemoteDataSource: VaccineRemoteDataSource
) {

    // TODO: REVISAR
//    val connectionHelper: ConnectionHelper by inject()


    suspend fun getVaccineCalendar(spainRegion: SpainRegion): Response<VaccineCalendar> {
        // TODO: Aplicar control de conexión a intenret y manejo de errores genéricos
        return vaccineRemoteDataSource.getVaccineCalendar(spainRegion)
    }
}