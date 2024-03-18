package com.ads.pethub.model

import com.google.gson.annotations.SerializedName

data class HealthRecord(
    val id: Int = 0,
    @SerializedName("cadastradoEm") val registeredOn: String = "",
    @SerializedName("dataVacina") val healthRecordDate: String = "",
    @SerializedName("descricaoVacina") val description: String = ""
)
