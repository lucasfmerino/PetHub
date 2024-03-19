package com.ads.pethub.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ads.pethub.model.Pet
import com.ads.pethub.service.PetHubFactory
import com.ads.pethub.service.auth.AuthManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PetProfileViewModel : ViewModel() {

    private val _pet = MutableLiveData<Pet>()
    val pet: LiveData<Pet> = _pet

//    private val authManager: AuthManager = AuthManager()

    fun getPet(
        petId: Long,
        onListReceived: () -> Unit
    ) {

        val token = AuthManager.accessToken

        if (token.isNotEmpty()) {
            PetHubFactory(token).getPetService().getPetById(petId)
                .enqueue(object : Callback<Pet> {
                    override fun onResponse(
                        call: Call<Pet>,
                        response: Response<Pet>
                    ) {
                        if (response.isSuccessful && response.body() != null) {
                            Log.i("PET SERVICE", "Código de resposta: ${response.code()}")
                            _pet.value = response.body()
                            onListReceived()

                        } else {
                            Log.e("PET SERVICE", "Erro na resposta: ${response.code()}")
                        }
                    }

                    override fun onFailure(call: Call<Pet>, t: Throwable) {
                        Log.e("PET SERVICE", "Falha na chamada: ${t.message}")
                    }

                })
        } else {
            Log.e("PET SERVICE", "Token é nulo ou vazio")
        }

    }

//    fun getPet(
//        petId: Long,
//        onListReceived: () -> Unit
//    ) {
//        authManager.getAccessToken {
//
//            val token = authManager.accessToken
//
//            if (token.isNotEmpty()) {
//                PetHubFactory(token).getPetService().getPetById(petId)
//                    .enqueue(object : Callback<Pet> {
//                        override fun onResponse(
//                            call: Call<Pet>,
//                            response: Response<Pet>
//                        ) {
//                            if (response.isSuccessful && response.body() != null) {
//                                Log.i("PET SERVICE", "Código de resposta: ${response.code()}")
//                                _pet.value = response.body()
//                                onListReceived()
//
//                            } else {
//                                Log.e("PET SERVICE", "Erro na resposta: ${response.code()}")
//                            }
//                        }
//
//                        override fun onFailure(call: Call<Pet>, t: Throwable) {
//                            Log.e("PET SERVICE", "Falha na chamada: ${t.message}")
//                        }
//
//                    })
//            } else {
//                Log.e("PET SERVICE", "Token é nulo ou vazio")
//            }
//        }
//    }
}
