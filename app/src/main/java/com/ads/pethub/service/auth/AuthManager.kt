package com.ads.pethub.service.auth

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthManager {

    companion object {

        private var _accessToken: String = ""
        var accessToken: String = _accessToken


        fun getAccessToken(
            onTokenReceived: () -> Unit,
            user: String,
            password: String
        ) {

            AuthFactory().getAuthService()
                .getAccessToken(username = user, password = password)
                .enqueue(object : Callback<AuthToken> {

                    override fun onResponse(
                        call: Call<AuthToken>,
                        response: Response<AuthToken>
                    ) {
                        if (response.isSuccessful) {
                            Log.i("RE ", "${response.code()}")
                            _accessToken = response.body()?.accessToken ?: ""
                            accessToken = _accessToken
                            onTokenReceived()
                        } else {
                            Log.e("RE ", "Erro ao receber token: ${response.code()}")
                        }
//                    accessToken = response.body()?.accessToken.toString()
                    }

                    override fun onFailure(call: Call<AuthToken>, t: Throwable) {
                        _accessToken = "Falha na chamada: ${t.message}"

                    }
                })
        }
    }
}


