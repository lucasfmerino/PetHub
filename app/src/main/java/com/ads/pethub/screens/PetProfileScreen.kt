package com.ads.pethub.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ads.pethub.R
import com.ads.pethub.components.PetOwnersCard
import com.ads.pethub.components.PetPortrait
import com.ads.pethub.components.PetProfileCardContent
import com.ads.pethub.components.StandardHeader
import com.ads.pethub.model.Pet
import com.ads.pethub.viewModel.PetProfileViewModel

@Composable
fun PetProfileScreen(
    navController: NavController,
    viewModel: PetProfileViewModel,
    userId: Long,
    petId: Long,
) {

    val petState = viewModel.pet.observeAsState(initial = Pet())

    viewModel.getPet(petId, onListReceived = {})

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            StandardHeader(onClick = { navController.navigate("home/$userId") })
            PetPortrait (petSpecies = petState.value.petSpecies) {}
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 120.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier
                    .padding(top = 180.dp)
                    .defaultMinSize(minHeight = 320.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                shape = RoundedCornerShape(
                    topStart = 120.dp,
                    topEnd = 120.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.pethub_light_gray)
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    PetProfileCardContent(
                        petDescription = "Lorem ",
                        petName = petState.value.name,
                        petAge = petState.value.birthdate, // modificar!
                        petType = petState.value.petSpecies,
                        petBreed = petState.value.breed,
                        petColor = petState.value.color,
                        petGender = "Macho",
                        microchip = petState.value.chipCode,
                        petFriendly = petState.value.friendly
                    )
                }
            }
            PetOwnersCard(
                ownerName = "Developer",
                phone = "+55 (11)98765-4321",
                email = "developer@email.com",
            ) {}
        }
    }
}
