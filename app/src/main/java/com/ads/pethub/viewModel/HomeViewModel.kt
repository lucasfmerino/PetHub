package com.ads.pethub.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ads.pethub.model.HealthRecord
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

    private val _pet = MutableLiveData<Pet>()
    val pet: LiveData<Pet> = _pet

    private val _healthRecords = MutableLiveData<List<HealthRecord>>()
    val healthRecords: LiveData<List<HealthRecord>> = _healthRecords


//    fun onPetListChanged(list: List<Pet>) {
//        _petList.value = list
//    }


    fun onPetChanged() {
        _pet.value = _petList.value?.find { it.id == _selectedPet.value } ?: Pet()
    }


    fun onSelectedPetChanged(id: Long) {
        _selectedPet.value = id
    }


    fun sortHealthRecords() {
        _healthRecords.value = _healthRecords.value?.sortedByDescending { it.id }
    }


    fun getPetList(
        onListReceived: () -> Unit
    ) {

        val token = AuthManager.accessToken

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
                                // PRÉ SELEÇÃO
                                if (_selectedPet.value == null) {
                                    onSelectedPetChanged(_petList.value!![0].id)
                                    onPetChanged()
                                }
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


    fun getHealthRecords(
        petId: Long,
        onListReceived: () -> Unit
    ) {

        val token = AuthManager.accessToken

        if (token.isNotEmpty()) {
            PetHubFactory(token).getHealthRecordService().getHealthRecords(petId)
                .enqueue(object : Callback<List<HealthRecord>> {
                    override fun onResponse(
                        call: Call<List<HealthRecord>>,
                        response: Response<List<HealthRecord>>
                    ) {
                        if (response.isSuccessful) {
                            Log.i(
                                "HEALTH RECORD SERVICE",
                                "Código de resposta: ${response.code()}"
                            )
                            _healthRecords.value = response.body()

                            if (_healthRecords.value?.isNotEmpty() == true) {
                                sortHealthRecords()
                                onListReceived()
                            }

                        } else {
                            Log.e(
                                "HEALTH RECORD SERVICE",
                                "Erro na resposta: ${response.code()}"
                            )
                        }
                    }

                    override fun onFailure(call: Call<List<HealthRecord>>, t: Throwable) {
                        Log.e("HEALTH RECORD SERVICE", "Falha na chamada: ${t.message}")
                    }
                })
        } else {
            Log.e("HEALTH RECORD SERVICE", "Token é nulo ou vazio")
        }
    }
}