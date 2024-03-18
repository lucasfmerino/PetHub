package com.ads.pethub.service

import com.ads.pethub.model.HealthRecord
import com.ads.pethub.model.HealthRecordPost
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface HealthRecordService {

    @GET("api/v1/historico-saude")
    fun getHealthRecords(@Query("animalId") petId: Long): Call<List<HealthRecord>>

    @POST("api/v1/historico-saude")
    fun postHealthRecord(
        @Body healthRecord: HealthRecordPost,
        @Query("animalId") petId: Long
    ): Call<HealthRecord>
}