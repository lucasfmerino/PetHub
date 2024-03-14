package com.ads.pethub.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ads.pethub.model.Pet
import com.ads.pethub.service.PetHubFactory
import com.ads.pethub.service.auth.AuthFactory
import com.ads.pethub.service.auth.AuthToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {


    private val _petList = MutableLiveData<List<Pet>>()
    val petList: LiveData<List<Pet>> = _petList

    private var _accessToken = MutableLiveData<String>()
    val accessToken: LiveData<String> = _accessToken

    fun onPetListChanged(list: List<Pet>) {
        _petList.value = list
    }


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


    fun getPetList(
        onTokenReceived: () -> Unit
    ) {

//        val token: String = accessToken.value ?: "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJHZjl3QlJsOU1RUTJpWEpvYWFJR2tEQ2ZwZGZ3VmloZGRxQkszRmJ6Z0lFIn0.eyJleHAiOjE3MTAzOTE3ODcsImlhdCI6MTcxMDM4ODE4NywianRpIjoiMThiOTFiYTgtZTA3Ny00ZDIwLThhM2QtYjRlYzA4OWYwNzljIiwiaXNzIjoiaHR0cHM6Ly9hY2Vzc28uY2d0ZWNub2xvZ2lhLmNvbS5ici9yZWFsbXMvcGV0aHViIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6Ijg1YWQ1NTk0LTdjODAtNGEyYy05NmZiLTdkMzQ2ODk5ZmJmMSIsInR5cCI6IkJlYXJlciIsImF6cCI6InBldGh1Yi1hcGkiLCJzZXNzaW9uX3N0YXRlIjoiZTY0OTA5MzktZjE0YS00ZGEzLWE5MjgtZDIxNGQ5Yzk4MTM1IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyIvKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiZGVmYXVsdC1yb2xlcy1wZXRodWIiLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsicGV0aHViLWFwaSI6eyJyb2xlcyI6WyJST0xFX1VTRVIiLCJST0xFX0FETUlOIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJlNjQ5MDkzOS1mMTRhLTRkYTMtYTkyOC1kMjE0ZDljOTgxMzUiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6Ikx1Y2FzIE1lcmlubyIsInByZWZlcnJlZF91c2VybmFtZSI6Imx1Y2FzLm1lcmlubyIsImdpdmVuX25hbWUiOiJMdWNhcyIsImZhbWlseV9uYW1lIjoiTWVyaW5vIiwiZW1haWwiOiJsdWNhc2ZtZXJpbm9AZ21haWwuY29tIn0.FWrQMmcdPz8qL6o7tGpYXuRYA5tNu6MfoAG6wPttbVOn4WQYediBbgrtd-7vEjrn9qIsPcymFTYM-QnEtkqZ9XPS62lyDqoGRlmJkuzUiUP5IysONfFrz8YWxv0A9GuTO_zLZmtN-3WYvcpk7BQgbbqwu70SORq_V4p8zi0uh1C2P1-qMGzRc_z0Ci0aoaFReJ-Z00srJ39H6MU97Nf4qTGliAp8RnzfGcoBXn6JOKFciIe3YuXM3pK5KLJYYSRwlf2BY6u_3RXyqQi8YzJ7n4d-2iEVPY0h7gty9gQtxu0zj5fw1gUlsJDn4BgsYyB-5fHt7QC8hm_tnV0sI6cwXA"
        val token: String = accessToken.value ?: ""

        if (token.isNotEmpty()) {
            PetHubFactory(token).getPetService().getPets().enqueue(object : Callback<List<Pet>> {
                override fun onResponse(call: Call<List<Pet>>, response: Response<List<Pet>>) {
                    if (response.isSuccessful && response.body() != null) {
                        Log.i("PET SERVICE", "Código de resposta: ${response.code()}")
                        _petList.value = response.body()
                        onTokenReceived()
                    } else {
                        Log.e("PET SERVICE", "Erro na resposta: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<Pet>>, t: Throwable) {
                    Log.e("PET SERVICE", "Falha na chamada: ${t.message}")
                }
            })
        } else {
            Log.e("PET SERVICE", "Token é nulo ou vazio")
        }
    }
}