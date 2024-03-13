package com.ads.pethub.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ads.pethub.model.Pet
import com.ads.pethub.service.PetHubFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPetViewModel : ViewModel() {

    private val _petName = MutableLiveData<String>()
    val petName: LiveData<String> = _petName

    private val _petBirthdate = MutableLiveData<String>()
    val petBirthdate: LiveData<String> = _petBirthdate

    private val _petType = MutableLiveData<String>()
    val petType: LiveData<String> = _petType

    private val _petBreed = MutableLiveData<String>()
    val petBreed: LiveData<String> = _petBreed

    private val _petColor = MutableLiveData<String>()
    val petColor: LiveData<String> = _petColor

    private val _petSex = MutableLiveData<String>()
    val petSex: LiveData<String> = _petSex

    private val _microchipNumber = MutableLiveData<String>()
    val microchipNumber: LiveData<String> = _microchipNumber

    private val _petFriendly = MutableLiveData<String>()
    val petFriendly: LiveData<String> = _petFriendly

    // Methods:

    fun onPetNameChanged(name: String) {
        _petName.value = name
    }

    fun onPetBirthdateChanged(birthdate: String) {
        _petBirthdate.value = birthdate
    }

    fun onPetTypeChanged(type: String) {
        _petType.value = type
    }

    fun onPetBreedChanged(breed: String) {
        _petBreed.value = breed
    }

    fun onPetColorChanged(color: String) {
        _petColor.value = color
    }

    fun onPetSexChanged(sex: String) {
        _petSex.value = sex
    }

    fun ontMicrochipNumberChanged(number: String) {
        _microchipNumber.value = number
    }

    fun ontPetFriendlyChanged(friendly: String) {
        _petFriendly.value = friendly
    }

    fun registerPet() {
        val newPet = Pet(
            name = _petName.value ?: "",
            birthdate = _petBirthdate.value ?: "",
            petSpecies = _petType.value ?: "",
            breed = _petBreed.value ?: "",
            color = _petColor.value ?: "",
            chipCode = _microchipNumber.value ?: "",
            friendly = _petFriendly.value ?: "",
        )

        PetHubFactory("** EM FASE DE TESTES: SUBSTITUIR PELA TOKEN **").getPetService().postPet(newPet).enqueue(
            object : Callback<Pet> {
                override fun onResponse(call: Call<Pet>, response: Response<Pet>) {
                    if (response.isSuccessful) {
                        Log.i("RegisterPetViewModel", "Pet registrado com sucesso: ${response.body()}")
                    } else {
                        Log.e("RegisterPetViewModel", "Erro ao registrar pet: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<Pet>, t: Throwable) {
                    Log.e("RegisterPetViewModel", "Falha na chamada da API", t)
                }
            }
        )
    }

}