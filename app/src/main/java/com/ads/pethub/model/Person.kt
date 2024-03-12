package com.ads.pethub.model

import com.google.gson.annotations.SerializedName

data class Person(
    val id: Int = 0,
    @SerializedName("nome") val name: String = "",
    @SerializedName("cpf") val document: String = "",
    @SerializedName("dataNascimento") val birthdate: String = "",
    @SerializedName("foto") val photograph: Photograph = Photograph()
)
