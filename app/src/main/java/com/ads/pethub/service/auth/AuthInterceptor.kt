package com.ads.pethub.service.auth

import okhttp3.Interceptor

class AuthInterceptor(private val accessToken: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "Bearer $accessToken")
            .build()
        return chain.proceed(request)
    }
}