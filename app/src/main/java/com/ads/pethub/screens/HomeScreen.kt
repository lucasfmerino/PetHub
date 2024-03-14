package com.ads.pethub.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ads.pethub.components.NavMenu
import com.ads.pethub.components.StandardButton
import com.ads.pethub.components.StandardHeader

@Composable
fun HomeScreen(
    navController: NavController,
    userId: Int
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            StandardHeader(
                onClick = { navController.navigate("/login") }
            )
            NavMenu(
//                action1 = { navController.navigate("${userId}/home") },
                action1 = { },
                action2 = { navController.navigate("${userId}/registerPet") },
                action3 = { navController.navigate("${userId}/petProfile/1") },
                action4 = { navController.navigate("${userId}/petFinder") },
                action5 = { navController.navigate("${userId}/registerPetRecord") }
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 32.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StandardButton(
                    text = "Cadastrar Pet",
                    onClick = {
                        navController.navigate("${userId}/registerPet")
                    }
                )

                StandardButton(
                    text = "Perfil do Pet",
                    onClick = {
                        navController.navigate("${userId}/petProfile/1")
                    }
                )

                StandardButton(
                    text = "Registro de Saúde Animal",
                    onClick = {
                        navController.navigate("${userId}/registerPetRecord")
                    }
                )

                StandardButton(
                    text = "Pets Perdidos",
                    onClick = {
                        navController.navigate("${userId}/petFinder")
                    }
                )

                StandardButton(
                    text = "Sair",
                    onClick = {
                        navController.navigate("/login")
                    }
                )

                StandardButton(
                    text = "Token Test",
                    onClick = {
                        navController.navigate("${userId}/token")
                    }
                )
            }
        }

    }
}
