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

class HomeViewModel : ViewModel() {


    private val _petList = MutableLiveData<List<Pet>>()
    val petList: LiveData<List<Pet>> = _petList

    private val _selectedPet = MutableLiveData<Long>()
    val selectedPet: LiveData<Long> = _selectedPet

    private val authManager: AuthManager = AuthManager()

    fun onPetListChanged(list: List<Pet>) {
        _petList.value = list
    }

    fun onSelectedPetChanged(id: Long) {
        _selectedPet.value = id
    }


    fun getPetList(
        onListReceived: () -> Unit
    ) {
        authManager.getAccessToken {

            val token = authManager.accessToken

            if (token.isNotEmpty()) {
                PetHubFactory(token).getPetService().getPets()
                    .enqueue(object : Callback<List<Pet>> {
                        override fun onResponse(
                            call: Call<List<Pet>>,
                            response: Response<List<Pet>>
                        ) {
                            if (response.isSuccessful && response.body() != null) {
                                Log.i("PET SERVICE", "Código de resposta: ${response.code()}")
                                _petList.value = response.body()

                                if (_petList.value?.isNotEmpty() == true) {
                                    onListReceived()
                                }

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
}