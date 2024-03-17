package com.ads.pethub.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ads.pethub.components.MissingPetCard
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardHeader
import com.ads.pethub.viewModel.PetFinderViewModel

@Composable
fun PetFinderScreen(
    navController: NavController,
    viewModel: PetFinderViewModel,
    userId: Long
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            StandardHeader(
                onClick = {
                    navController.navigate("home/$userId")
                }
            )
            ScreenTitle(title = "DESAPARECIDOS")

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(viewModel.missingPetsMock) { pet ->
                    MissingPetCard(
                        petName = pet.petName,
                        image = painterResource(id = pet.image),
                        date = pet.date,
                        time = pet.time,
                        address = pet.address,
                        number = pet.number,
                        neighborhood = pet.neighborhood,
                        city = pet.city,
                        state = pet.state,
                        cardAction = {}
                    )
                }
            }
        }
    }
}