package com.example.vacunas.data.repository.remote

import com.example.vacunas.data.model.SpainRegion
import com.example.vacunas.data.model.VaccineCalendar
import com.example.vacunas.data.repository.RemoteRepositoryInterface
import com.example.vacunas.data.repository.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class RemoteRepository : RemoteRepositoryInterface, KoinComponent {

    private val service: APIRestInterface by inject()

    override suspend fun getVaccineCalendar(spainRegion: SpainRegion): Response<VaccineCalendar> {
        return withContext(Dispatchers.IO) {
            val myResponse: Response<VaccineCalendar> = try {
                val response = service.getVaccineCalendar(spainRegion)
                if (response.isSuccessful) {
                    Response.Success(
                        VaccineCalendar(
                            response.body()!!.vaccineResponseList,
                            response.body()?.notes
                        )
                    )
                } else {
                    Response.Error("no success: ${response.code()}")
                }
            } catch (e: Exception) {
                Response.Error(e.message ?: "unknown")
            }

            myResponse
        }
    }
}