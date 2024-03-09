package com.ads.pethub.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardHeader

@Composable
fun PetProfileScreen(
    navController: NavController,
    userId: Int,
    petId: Int
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            StandardHeader(
                onClick = {
                    navController.navigate("home")
                }
            )
            ScreenTitle(title = "PERFIL DO PET")
        }
    }

}