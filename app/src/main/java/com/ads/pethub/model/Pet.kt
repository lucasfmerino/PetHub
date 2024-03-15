package com.ads.pethub.model

import com.google.gson.annotations.SerializedName

data class Pet(
    val id: Long = 0,
    @SerializedName("nome") val name: String = "",
    @SerializedName("nomeCientífico") val scientificName: String = "",
    @SerializedName("nomeEspecie") val petSpecies: String = "",
    @SerializedName("cor") val color: String = "",
    @SerializedName("codigoChip") val chipCode: String = "",
    @SerializedName("códigoTatuagem") val tattooCode: String = "",
    @SerializedName("dataNascimento") val birthdate: String = "",
    @SerializedName("tamanhoPorte") val petSize: String = "",
    @SerializedName("peso") val weight: String = "",
    @SerializedName("temperamento") val friendly: String = "",
    @SerializedName("raca") val breed: String = "",
//    @SerializedName("foto") val photograph: String = "",
)