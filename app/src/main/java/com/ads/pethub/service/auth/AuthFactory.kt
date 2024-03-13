package com.ads.pethub.service.auth

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthFactory {

    private val authUrl =
        "https://acesso.cgtecnologia.com.br/realms/pethub/protocol/openid-connect/token"

    private val authFactory = Retrofit
        .Builder()
        .baseUrl(authUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAuthService(): AuthService {
        return authFactory.create(AuthService::class.java)
    }

}