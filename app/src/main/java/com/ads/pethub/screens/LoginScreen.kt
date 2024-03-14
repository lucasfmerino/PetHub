package com.ads.pethub.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardButton
import com.ads.pethub.model.Pet
import com.ads.pethub.viewModel.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel
) {

    val userName = viewModel.userName.observeAsState(initial = "lucas.merino")
    val password = viewModel.password.observeAsState(initial = "IMhObKL4MAiyFrk=")
    val token = viewModel.accessToken.observeAsState(initial = "")
    val userPetList = viewModel.petList.observeAsState(initial = emptyList<Pet>()).value

    val userId: Int = 1

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {

            ScreenTitle(title = "Login")

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 32.dp)
            ) {

                StandardButton(
                    text = "Login",
                    onClick = {
                        viewModel.getAccessToken {
                            viewModel.getPetList {
                                navController.navigate("${userId}/home")
                            }
                        }
                    }
                )

//                Text(text = token.value)
//
//                Spacer(modifier = Modifier.height(25.dp))
//
//                Text(text = "Pets:")
//
//                LazyRow {
//                    items(userPetList) { pet ->
//                        Text(text = pet.name)
//                    }
//                }

            }
        }
    }
}