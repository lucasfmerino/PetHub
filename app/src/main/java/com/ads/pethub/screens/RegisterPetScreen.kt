package com.ads.pethub.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ads.pethub.R
import com.ads.pethub.components.DateInput
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardButton
import com.ads.pethub.components.StandardHeader
import com.ads.pethub.components.StandardInput
import com.ads.pethub.model.Pet
import com.ads.pethub.viewModel.RegisterPetViewModel

@Composable
fun RegisterPetScreen(
    navController: NavController,
    userId: Long,
    viewModel: RegisterPetViewModel
) {

    val petNameState = viewModel.petName.observeAsState(initial = "")
    val scientificNameState = viewModel.scientificName.observeAsState(initial = "")
    val petBirthdateState = viewModel.petBirthdate.observeAsState(initial = "")
//    val formattedDateState = viewModel.formattedDate.observeAsState(initial = "")
    val petTypeState = viewModel.petType.observeAsState(initial = "")
    val petBreedState = viewModel.petBreed.observeAsState(initial = "")
    val petColorState = viewModel.petColor.observeAsState(initial = "")
    val petSizeState = viewModel.petSize.observeAsState(initial = "")
    val petWeightState = viewModel.petWeight.observeAsState(initial = 0.0)
    val microchipNumberState = viewModel.microchipNumber.observeAsState(initial = "")
    val tattooCodeState = viewModel.tattooCode.observeAsState(initial = "")
    val petFriendlyState = viewModel.petFriendly.observeAsState(initial = "")
    val newPetState = viewModel.newPet.observeAsState(initial = Pet())

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            StandardHeader(onClick = { navController.navigate("home/$userId") })
            ScreenTitle(title = "CADASTRAR PET")
            IconButton(onClick = {}, modifier = Modifier.size(90.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.photo_icon),
                    contentDescription = "Photo Icon",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(360.dp)
                        .padding(vertical = 16.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    items(1) {
                        StandardInput(value = petNameState.value, placeHolder = "Nome:") {
                            viewModel.onPetNameChanged(it)
                        }
                        StandardInput(
                            value = scientificNameState.value,
                            placeHolder = "Nome científico:"
                        ) {
                            viewModel.onScientificNameChanged(it)
                        }
                        DateInput(
                            value = petBirthdateState.value,
                            placeHolder = "Data de nascimento: "
                        ) {
                            viewModel.onPetBirthdateChanged(it)
                        }
                        StandardInput(value = petTypeState.value, placeHolder = "Tipo:") {
                            viewModel.onPetTypeChanged(it)
                        }
                        StandardInput(value = petBreedState.value, placeHolder = "Raça:") {
                            viewModel.onPetBreedChanged(it)
                        }
                        StandardInput(value = petColorState.value, placeHolder = "Cor:") {
                            viewModel.onPetColorChanged(it)
                        }
                        StandardInput(value = petSizeState.value, placeHolder = "Porte:") {
                            viewModel.onPetSizeChanged(it)
                        }
                        StandardInput(
                            value = petWeightState.value.toString(),
                            placeHolder = "0.0"
                        ) {
                            viewModel.onPetWeightChanged(it.toDouble())
                        }
                        StandardInput(
                            value = microchipNumberState.value,
                            placeHolder = "Microchip:"
                        ) {
                            viewModel.ontMicrochipNumberChanged(it)
                        }
                        StandardInput(value = tattooCodeState.value, placeHolder = "Tatuagem:") {
                            viewModel.onTattooCodeChanged(it)
                        }
                        StandardInput(
                            value = petFriendlyState.value,
                            placeHolder = "Temperamento:"
                        ) {
                            viewModel.ontPetFriendlyChanged(it)
//                            petFriendly.value = it
                        }
                        Spacer(modifier = Modifier.height(250.dp))
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                StandardButton(text = "Add") {
                    viewModel.onFormattedDateChangedAndRegister(petBirthdateState.value) {
                        navController.navigate("petProfile/${userId}/${newPetState.value.id}")
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
