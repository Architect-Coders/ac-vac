package com.example.data

import com.example.data.utils.Response
import com.example.domain.SpainRegion
import com.example.domain.VaccineCalendar
import org.koin.core.KoinComponent
import org.koin.core.inject


class VaccineRepository : KoinComponent {

    val vaccineRemoteDataSource: VaccineRemoteDataSource by inject()

    // TODO: REVISAR
//    val connectionHelper: ConnectionHelper by inject()


    suspend fun getVaccineCalendar(spainRegion: SpainRegion): Response<VaccineCalendar> {
        // TODO: Aplicar control de conexión a intenret y manejo de errores genéricos
        return vaccineRemoteDataSource.getVaccineCalendar(spainRegion)
    }
}

interface VaccineDataSource

interface VaccineLocalDataSource : VaccineDataSource

interface VaccineRemoteDataSource : VaccineDataSource {
    fun getVaccineCalendar(spainRegion: SpainRegion): Response<VaccineCalendar>
}