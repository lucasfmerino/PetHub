package com.ads.pethub.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterPetViewModel: ViewModel() {

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

}