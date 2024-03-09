package com.ads.pethub.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardButton

@Composable
fun HomeScreen(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
//            StandardHeader(
//                onClick = { }
//            )
            ScreenTitle(title = "HOME")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StandardButton(
                    text = "Cadastrar Pet",
                    onClick = {
                        navController.navigate("1/registerPet")
                    }
                )

                StandardButton(
                    text = "Perfil do Pet",
                    onClick = {
                        navController.navigate("1/petProfile/1")
                    })

                StandardButton(
                    text = "Registro de Saúde Animal",
                    onClick = {
                        navController.navigate("1/registerPetRecord")
                    }
                )

                StandardButton(
                    text = "Pets Perdidos",
                    onClick = {
                        navController.navigate("1/petFinder")
                    }
                )
            }
        }
    }
}
