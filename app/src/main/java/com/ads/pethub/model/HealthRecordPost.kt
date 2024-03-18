package com.ads.pethub.model

import com.google.gson.annotations.SerializedName

data class HealthRecordPost(
    @SerializedName("tipo") val type: String = "",
    @SerializedName("dataVacina") val healthRecordDate: String = "",
    @SerializedName("descricaoVacina") val description: String = "",
)
