package com.ads.pethub.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ads.pethub.service.auth.AuthManager

class LoginViewModel : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isVisible = MutableLiveData<Boolean>()
    val isVisible: LiveData<Boolean> = _isVisible

//    private val authManager: AuthManager = AuthManager()

    private val _userId: Long = 1


    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun onUsernameChanged(newUsername: String) {
        _userName.value = newUsername
    }

    fun onIsVisibleChanged() {
        _isVisible.value = _isVisible.value != true
    }


    fun getUserId(): Long {
        return _userId
    }

    fun getAccessToken(
        onTokenReceived: () -> Unit
    ) {
        _userName.value?.let { _password.value?.let { it1 ->
            AuthManager.getAccessToken(onTokenReceived, it,
                it1, )
        } }
    }

}