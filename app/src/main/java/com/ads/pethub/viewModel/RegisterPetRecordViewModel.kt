package com.ads.pethub.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ads.pethub.model.HealthRecord
import com.ads.pethub.model.HealthRecordPost
import com.ads.pethub.model.Pet
import com.ads.pethub.service.PetHubFactory
import com.ads.pethub.service.auth.AuthManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class RegisterPetRecordViewModel: ViewModel() {

    private val _pet = MutableLiveData<Pet>()
    val pet: LiveData<Pet> = _pet

    private val _healthRecordList = MutableLiveData<List<HealthRecord>>()
    val healthRecordList: LiveData<List<HealthRecord>> = _healthRecordList

    private val _selectedRadioValue = MutableLiveData<Int>()
    val selectedRadioValue: LiveData<Int> = _selectedRadioValue

    private val _healthRecordType = MutableLiveData<String>()
    val healthRecordType: LiveData<String> = _healthRecordType

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    private val _time = MutableLiveData<String>()
    val time: LiveData<String> = _time

    private val _description = MutableLiveData<String>()
    val description: LiveData<String> = _description

    private val _carouselIndex = MutableLiveData<Int>()
    val carouselIndex: LiveData<Int> = _carouselIndex

    private val authManager: AuthManager = AuthManager()


    fun onSelectedRadioValueChanged(value: Int) {
        _selectedRadioValue.value = value
    }


    fun onDescriptionChanged(newDescription: String) {
        _description.value = newDescription
    }


    fun onHealthRecordTypeChanged() {
        when (_selectedRadioValue.value) {
            2 -> _healthRecordType.value = "VACINA"
            3 -> _healthRecordType.value = "MEDICAÇÃO"
            else -> _healthRecordType.value = "EXAME"
        }
    }


    fun getFormattedDate(date: String): String {
        val originalFormat = DateTimeFormatter.ISO_LOCAL_DATE
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val localDate = LocalDate.parse(date, originalFormat)
        return formatter.format(localDate)
    }


    fun getCurrentDate() {
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        _date.value = currentDate.format(formatter)
    }


    private fun getRegisterDate(): String {
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return currentDate.format(formatter)
    }


    fun getCurrentTime() {
        val currentTime = LocalTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        _time.value = currentTime.format(formatter)
    }


    fun onCarouselIndexChanged(index: Int) {
        _carouselIndex.value = index
    }


    fun toPreviousItem() {
        if(_carouselIndex.value == null) {onCarouselIndexChanged(0)}
        if(_carouselIndex.value!! > 0) {_carouselIndex.value = _carouselIndex.value!! - 1}
    }


    fun toNextItem(maxIndex: Int) {
        if(_carouselIndex.value == null) {onCarouselIndexChanged(0)}
        if(_carouselIndex.value!! < maxIndex -1) {_carouselIndex.value = _carouselIndex.value!! + 1}
    }


    fun sortHealthRecordList() {
        _healthRecordList.value = _healthRecordList.value?.sortedByDescending { it.id }
    }


    fun getPet(
        petId: Long,
        onListReceived: () -> Unit
    ) {
        authManager.getAccessToken {

            val token = authManager.accessToken

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
    }


    fun getHealthRecordList(
        petId: Long,
        onListReceived: () -> Unit
    ) {
        authManager.getAccessToken {

            val token = authManager.accessToken

            if (token.isNotEmpty()) {
                PetHubFactory(token).getHealthRecordService().getHealthRecords(petId)
                    .enqueue(object : Callback<List<HealthRecord>> {
                        override fun onResponse(
                            call: Call<List<HealthRecord>>,
                            response: Response<List<HealthRecord>>
                        ) {
                            if (response.isSuccessful && response.body() != null) {
                                Log.i("HEALTH RECORD SERVICE", "Código de resposta: ${response.code()}")
                                _healthRecordList.value = response.body()

                                if (_healthRecordList.value?.isNotEmpty() == true) {
                                    sortHealthRecordList()
                                    onListReceived()
                                }

                            } else {
                                Log.e("HEALTH RECORD SERVICE", "Erro na resposta: ${response.code()}")
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


    fun registerHealthRecord(
        petId: Long,
        onRecordReceived: () -> Unit
    ) {
        val newHealthRecord = HealthRecordPost(
            type = _healthRecordType.value ?: "",
            healthRecordDate = getRegisterDate(),
            description = _description.value ?: "",
        )

        val token = authManager.accessToken

        authManager.getAccessToken {
            PetHubFactory(token).getHealthRecordService()
                .postHealthRecord(petId = petId, healthRecord = newHealthRecord).enqueue(
                    object : Callback<HealthRecord> {
                        override fun onResponse(call: Call<HealthRecord>, response: Response<HealthRecord>) {
                            if (response.isSuccessful) {
                                Log.i(
                                    "RegisterHealthRecordViewModel",
                                    "Pet registrado com sucesso: ${response.body()} "
                                )
                                getHealthRecordList(petId) {}
                                onRecordReceived()
                            } else {
                                Log.e(
                                    "RegisterHealthRecordViewModel",
                                    "Erro ao cadastrar: ${
                                        response.errorBody()?.string()
                                    } - ${response.code()}"
                                )
                            }
                        }

                        override fun onFailure(call: Call<HealthRecord>, t: Throwable) {
                            Log.e("RegisterHealthRecordViewModel", "Falha na chamada da API", t)
                        }
                    }
                )
        }
    }
}