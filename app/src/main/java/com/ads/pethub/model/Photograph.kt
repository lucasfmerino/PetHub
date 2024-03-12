package com.ads.pethub.model

import com.google.gson.annotations.SerializedName

data class Photograph(
    val id: Int = 0,
    @SerializedName("tamanho") val size: String = "",
    @SerializedName("nomeArquivo") val fileName: String = "",
    @SerializedName("tipo") val fileType: String = "",
    @SerializedName("subpasta") val subfolder: String = "",
    @SerializedName("cadastradoEm") val registeredOn: String = "",
)
