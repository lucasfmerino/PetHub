package com.ads.pethub.service

import com.ads.pethub.model.Pet
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PetService {

    @GET("api/v1/animal/detalhes")
    fun getPetById(@Query("id") petId: Long): Call<Pet>

    @GET("api/v1/animal")
    fun getPets(): Call<List<Pet>>

    @POST("api/v1/animal")
    fun postPet(@Body pet: Pet): Call<Pet>

}