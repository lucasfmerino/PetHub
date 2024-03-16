package com.ads.pethub.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ads.pethub.model.Pet
import com.ads.pethub.model.PetPost
import com.ads.pethub.service.PetHubFactory
import com.ads.pethub.service.auth.AuthManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPetViewModel : ViewModel() {

    private val _petName = MutableLiveData<String>()
    val petName: LiveData<String> = _petName

    private val _scientificName = MutableLiveData<String>()
    val scientificName: LiveData<String> = _scientificName

    private val _petBirthdate = MutableLiveData<String>()
    val petBirthdate: LiveData<String> = _petBirthdate

    private val _petType = MutableLiveData<String>()
    val petType: LiveData<String> = _petType

    private val _petBreed = MutableLiveData<String>()
    val petBreed: LiveData<String> = _petBreed

    private val _petSize = MutableLiveData<String>()
    val petSize: LiveData<String> = _petSize

    private val _petWeight = MutableLiveData<Double>()
    val petWeight: LiveData<Double> = _petWeight

    private val _petColor = MutableLiveData<String>()
    val petColor: LiveData<String> = _petColor

//    private val _petGender = MutableLiveData<String>()
//    val petGender: LiveData<String> = _petGender

    private val _microchipNumber = MutableLiveData<String>()
    val microchipNumber: LiveData<String> = _microchipNumber

    private val _tattooCode = MutableLiveData<String>()
    val tattooCode: LiveData<String> = _tattooCode

    private val _petFriendly = MutableLiveData<String>()
    val petFriendly: LiveData<String> = _petFriendly

    private val _newPet = MutableLiveData<Pet>()
    val newPet: LiveData<Pet> = _newPet

    private val authManager: AuthManager = AuthManager()

    // Methods:

    fun onPetNameChanged(name: String) {
        _petName.value = name
    }

    fun onScientificNameChanged(name: String) {
        _scientificName.value = name
    }

    fun onPetSizeChanged(size: String) {
        _petSize.value = size
    }

    fun onPetWeightChanged(weight: Double) {
        _petWeight.value = weight
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

//    fun onPetGenderChanged(gender: String) {
//        _petGender.value = gender
//    }

    fun ontMicrochipNumberChanged(number: String) {
        _microchipNumber.value = number
    }

    fun onTattooCodeChanged(code: String) {
        _tattooCode.value = code
    }

    fun ontPetFriendlyChanged(friendly: String) {
        _petFriendly.value = friendly
    }


    fun registerPet(
        onListReceived: () -> Unit
    ) {
        val newPet = PetPost(
            name = _petName.value ?: "",
            scientificName = _scientificName.value ?: "",
            birthdate = _petBirthdate.value ?: "",
            petSpecies = _petType.value ?: "",
            petSize = _petSize.value ?: "",
            breed = _petBreed.value ?: "",
            weight = _petWeight.value ?: 0.0,
            color = _petColor.value ?: "",
            chipCode = _microchipNumber.value ?: "",
            tattooCode = _tattooCode.value ?: "",
            friendly = _petFriendly.value ?: "",
        )

        val token = authManager.accessToken

        authManager.getAccessToken {
            PetHubFactory(token).getPetService()
                .postPet(newPet).enqueue(
                    object : Callback<Pet> {
                        override fun onResponse(call: Call<Pet>, response: Response<Pet>) {
                            if (response.isSuccessful) {
                                Log.i(
                                    "RegisterPetViewModel",
                                    "Pet registrado com sucesso: ${response.body()} "
                                )
                                _newPet.value = response.body()
                                onListReceived()
                            } else {
                                Log.e(
                                    "RegisterPetViewModel",
                                    "Erro ao registrar pet: ${
                                        response.errorBody()?.string()
                                    } - ${response.code()}"
                                )
                            }
                        }

                        override fun onFailure(call: Call<Pet>, t: Throwable) {
                            Log.e("RegisterPetViewModel", "Falha na chamada da API", t)
                        }
                    }
                )
        }
    }
}
