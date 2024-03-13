package com.ads.pethub.service.auth

import com.google.gson.annotations.SerializedName

data class AuthRequest(
    @SerializedName("grant_type") val grantType: String,
    @SerializedName("client_id") val clientId: String,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("client_secret") val clientSecret: String
)
