package com.ads.pethub.service

import com.ads.pethub.service.auth.AuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PetHubFactory(accessToken: String) {

    private val baseUrl = "https://pethub-hml.cgtecnologia.com.br/"

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(accessToken))
        .build()

    private val petHubFactory = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getPetService(): PetService {
        return petHubFactory.create(PetService::class.java)
    }

    fun getHealthRecordService(): HealthRecordService {
        return petHubFactory.create(HealthRecordService::class.java)
    }
}