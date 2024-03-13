package com.ads.pethub.service.auth

import com.google.gson.annotations.SerializedName

data class AuthToken(
    @SerializedName("access_token") val accessToken: String = "",
    @SerializedName("expires_in") val expiresIn: Int = 0,
    @SerializedName("refresh_expires_in") val refreshExpiresIn: Int = 0,
    @SerializedName("refresh_token") val refreshToken: String = "",
)
