package com.ads.pethub.model

import com.google.gson.annotations.SerializedName

data class HeathRecord(
    val id: Int = 0,
    @SerializedName("cadastradoEm") val registeredOn: String = "",
    val animal: Animal = Animal()
)
