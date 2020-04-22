package com.example.vacunas.data.repository.remote

import com.example.data.VaccineRemoteDataSource
import com.example.data.utils.Response
import com.example.domain.SpainRegion
import com.example.domain.VaccineCalendar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.Collections.emptyList

class VaccineRetrofitDataSource : VaccineRemoteDataSource, KoinComponent {

    private val service: APIRestInterface by inject()


    override fun getVaccineCalendar(spainRegion: SpainRegion): Response<VaccineCalendar> {
        return Response.Success(VaccineCalendar(emptyList(), null))
    }

//    private val service: APIRestInterface by inject()

//    override suspend fun getVaccineCalendar(spainRegion: SpainRegion): Response<VaccineCalendar> {
//        return withContext(Dispatchers.IO) {
//            val myResponse: Response<VaccineCalendar> = try {
//                val response = service.getVaccineCalendar(spainRegion)
//                if (response.isSuccessful) {
//                    Response.Success(
////                        VaccineCalendar(
////                            response.body()!!.vaccineResponseList,
////                            response.body()?.notes
////                        )
//                    VaccineCalendar(emptyList(), null)
//                    )
//                } else {
//                    Response.Error("no success: ${response.code()}")
//                }
//            } catch (e: Exception) {
//                Response.Error(e.message ?: "unknown")
//            }
//
//            myResponse
//        }
//    }
}