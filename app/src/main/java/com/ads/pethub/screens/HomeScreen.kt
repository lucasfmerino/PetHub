package com.ads.pethub.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ads.pethub.R
import com.ads.pethub.components.MissingPetCard
import com.ads.pethub.components.NavMenu
import com.ads.pethub.components.PetBirthdayContainer
import com.ads.pethub.components.PetSelector
import com.ads.pethub.components.PetUpdateInfo
import com.ads.pethub.components.StandardHeader
import com.ads.pethub.components.ThinText
import com.ads.pethub.components.TopicTitle
import com.ads.pethub.model.Pet
import com.ads.pethub.ui.theme.RobotoBold
import com.ads.pethub.ui.theme.RobotoRegular
import com.ads.pethub.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel,
    userId: Int,
) {

    val petListState = viewModel.petList.observeAsState(initial = emptyList()).value
    val selectedPetState = viewModel.selectedPet.observeAsState(
        initial = if (petListState.isNotEmpty()) petListState[0].id else 999L
    ).value

    val pet: Pet = petListState.find { it.id == selectedPetState } ?: Pet()

    viewModel.getPetList {}


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
                action3 = { navController.navigate("${userId}/petProfile/${selectedPetState}") },
                action4 = { navController.navigate("${userId}/petFinder") },
                action5 = { navController.navigate("${userId}/registerPetRecord") }
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // LISTA DE PETS:
                Spacer(modifier = Modifier.height(8.dp))

                petListState.find { it.id == selectedPetState }?.let { selectedPet ->
                    Text(
                        text = selectedPet.name,
                        fontFamily = RobotoBold,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.pethub_main_blue),
                    )
                } ?: Text(
                    text = "Selecionar Pet: ",
                    fontFamily = RobotoBold,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.pethub_main_blue)
                )
                Spacer(modifier = Modifier.height(8.dp))

                LazyRow(
                    modifier = Modifier.padding(horizontal = 32.dp)
                ) {
                    items(petListState) { pet ->
                        PetSelector(
                            action = { viewModel.onSelectedPetChanged(pet.id) },
                            pet = pet,
                            selected = selectedPetState
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {
                    Text(
                        text = "Últimas atualizações",
                        fontFamily = RobotoRegular,
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.pethub_main_blue),
                        textAlign = TextAlign.Left,
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {

                    Column(
                        modifier = Modifier.padding(horizontal = 32.dp)
                    ) {
                        // HEALTH UPDATE
                        TopicTitle(
                            painter = painterResource(id = R.drawable.health_care),
                            topic = "UPDATES NA SAÚDE DO PET"
                        )
                        PetUpdateInfo(pet = pet)
                        Spacer(modifier = Modifier.height(22.dp))


                        // REPORT - DESAPARECIDOS
                        TopicTitle(
                            painter = painterResource(id = R.drawable.pet_finder),
                            topic = "NOVOS DESAPARECIMENTOS REPORTADOS"
                        )
                        Row {
                            MissingPetCard(
                                petName = "Átila",
                                image = painterResource(id = R.drawable.dog_placeholder),
                                date = "10/03/2024",
                                time = "19h30",
                                address = "Av. Cruzeiro do Sul",
                                number = "1800",
                                neighborhood = "Santana",
                                city = "São Paulo",
                                state = "SP"
                            ) {}
                            Spacer(modifier = Modifier.width(12.dp))
                            MissingPetCard(
                                petName = "Barbie",
                                image = painterResource(id = R.drawable.cat2_placeholder),
                                date = "14/03/2024",
                                time = "14h30",
                                address = "Av. Nova Independência",
                                number = "850",
                                neighborhood = "Brooklin Paulista",
                                city = "São Paulo",
                                state = "SP"
                            ) {}
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            OutlinedButton(
                                onClick = { navController.navigate("${userId}/petFinder") },
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(160.dp),
                                border = BorderStroke(0.dp, Color(0x00FFFFFF)),

                                ) {
                                Text(
                                    text = "Ver mais >>",
                                    textAlign = TextAlign.Right,
                                    color = colorResource(id = R.color.pethub_main_gray),
                                    fontFamily = RobotoRegular,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(800)
                                )
                            }
                        }
//                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    Column(
                        modifier = Modifier.padding(horizontal = 32.dp)
                    ) {
                        // PETS ANIVERSÁRIO
                        TopicTitle(
                            painter = painterResource(id = R.drawable.calendar_icon),
                            topic = "VAMOS CELEBRAR?!"
                        )

                        ThinText(text = "Confira que está soprando as velinhas", fontSize = 14)

                        Spacer(modifier = Modifier.height(22.dp))

                    }
                    PetBirthdayContainer()
                }
            }
        }
    }
}
