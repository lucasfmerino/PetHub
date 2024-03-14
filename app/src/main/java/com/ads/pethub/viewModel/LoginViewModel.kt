package com.ads.pethub.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ads.pethub.service.auth.AuthFactory
import com.ads.pethub.service.auth.AuthToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private var _accessToken = MutableLiveData<String>()
    val accessToken: LiveData<String> = _accessToken


    fun getAccessToken(
        onTokenReceived: () -> Unit
    ) {
        var token: String
//        val accessUser: String = _userName.value!!.ifEmpty { "lucas.merino" }
        val accessUser = "lucas.merino"
//        val accessPassword: String = _userName.value!!.ifEmpty { "IMhObKL4MAiyFrk=" }
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
                        token = response.body()?.accessToken ?: ""
                        _accessToken.value = token
                        onTokenReceived()
                    } else {
                        Log.e("RE ", "Erro ao receber token: ${response.code()}")
                    }

                    token = response.body()?.accessToken.toString()
                    _accessToken.value = token
                }

                override fun onFailure(call: Call<AuthToken>, t: Throwable) {
                    token = "Falha na chamada: ${t.message}"

                }
            })
    }

}