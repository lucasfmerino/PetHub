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
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardButton
import com.ads.pethub.components.StandardHeader
import com.ads.pethub.components.StandardInput
import com.ads.pethub.viewModel.RegisterPetViewModel

@Composable
fun RegisterPetScreen(
    navController: NavController,
    userId: Int,
    viewModel: RegisterPetViewModel
) {

    val petName = viewModel.petName.observeAsState(initial = "")
    val petBirthdate = viewModel.petBirthdate.observeAsState(initial = "")
    val petType = viewModel.petType.observeAsState(initial = "")
    val petBreed = viewModel.petBreed.observeAsState(initial = "")
    val petColor = viewModel.petColor.observeAsState(initial = "")
    val petSex = viewModel.petSex.observeAsState(initial = "")
    val microchipNumber = viewModel.microchipNumber.observeAsState(initial = "")
    val petFriendly = viewModel.petFriendly.observeAsState(initial = "")
//  val petFriendly = remember { mutableStateOf("") }

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
            StandardHeader(onClick = { navController.navigate("${userId}/home") })
            ScreenTitle(title = "CADASTRAR PET")
            IconButton(onClick = {}, modifier = Modifier.size(90.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.photo_icon),
                    contentDescription = "Photo Icon",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column (
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
                        StandardInput(value = petName.value, placeHolder = "Name:") {
                            viewModel.onPetNameChanged(it)
                        }
                        StandardInput(value = petBirthdate.value, placeHolder = "Birthdate:") {
                            viewModel.onPetBirthdateChanged(it)
                        }
                        StandardInput(value = petType.value, placeHolder = "Type:") {
                            viewModel.onPetTypeChanged(it)
                        }
                        StandardInput(value = petBreed.value, placeHolder = "Breed:") {
                            viewModel.onPetBreedChanged(it)
                        }
                        StandardInput(value = petColor.value, placeHolder = "Color:") {
                            viewModel.onPetColorChanged(it)
                        }
                        StandardInput(value = petSex.value, placeHolder = "Sex:") {
                            viewModel.onPetSexChanged(it)
                        }
                        StandardInput(value = microchipNumber.value, placeHolder = "Microchip Number:") {
                            viewModel.ontMicrochipNumberChanged(it)
                        }
                        StandardInput(value = petFriendly.value, placeHolder = "Friendly:") {
                            viewModel.ontPetFriendlyChanged(it)
//                            petFriendly.value = it
                        }
                        Spacer(modifier = Modifier.height(250.dp))
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                StandardButton(text = "Add") { viewModel.registerPet() }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


// ADICIONAR PESO
// ADICIONAR PORTE
