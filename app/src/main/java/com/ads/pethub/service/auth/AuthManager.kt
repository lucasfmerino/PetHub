package com.ads.pethub.service.auth

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthManager {

    private var _accessToken: String = ""
    var accessToken: String = ""

    fun getAccessToken(
        onTokenReceived: () -> Unit,
        ) {

        //        val accessUser: String = _userName.value!!.ifEmpty { "lucas.merino" }
        //        val accessPassword: String = _userName.value!!.ifEmpty { "IMhObKL4MAiyFrk=" }

        val accessUser = "lucas.merino"
        val accessPassword = "IMhObKL4MAiyFrk="

        AuthFactory().getAuthService()
            .getAccessToken(username = accessUser, password = accessPassword)
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


