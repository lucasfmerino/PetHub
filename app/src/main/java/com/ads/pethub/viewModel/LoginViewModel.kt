package com.ads.pethub.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ads.pethub.service.auth.AuthFactory
import com.ads.pethub.service.auth.AuthManager
import com.ads.pethub.service.auth.AuthToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val authManager: AuthManager = AuthManager()

    fun getAccessToken(
        onTokenReceived: () -> Unit
    ) {
        authManager.getAccessToken(onTokenReceived)
    }

}