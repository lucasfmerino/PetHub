package com.ads.pethub.service.auth

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("")
    fun getAccessToken(
        @Body authRequest: AuthRequest,
    ): Call<AuthToken>
}