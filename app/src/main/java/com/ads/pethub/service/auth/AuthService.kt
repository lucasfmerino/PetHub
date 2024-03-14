package com.ads.pethub.service.auth

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    @FormUrlEncoded
    @POST("token")
    fun getAccessToken(
//        @Body authRequest: AuthRequest,
        @Field("grant_type") grantType: String = "password",
        @Field("client_id") clientId: String = "pethub-api",
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("client_secret") clientSecret: String = "ORghXmmumTN11vqZP1a6tQcbp0V86Cfe"
    ): Call<AuthToken>
}
