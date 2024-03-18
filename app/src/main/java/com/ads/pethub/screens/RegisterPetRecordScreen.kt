package com.ads.pethub.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ads.pethub.R
import com.ads.pethub.components.PetSelector
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardButton
import com.ads.pethub.components.StandardHeader
import com.ads.pethub.components.StandardInput
import com.ads.pethub.components.StandardRadioButton
import com.ads.pethub.model.Pet
import com.ads.pethub.ui.theme.RobotoBold
import com.ads.pethub.ui.theme.RobotoThin
import com.ads.pethub.viewModel.RegisterPetRecordViewModel

@Composable
fun RegisterPetRecordScreen(
    navController: NavController,
    viewModel: RegisterPetRecordViewModel,
    userId: Long,
    petId: Long
) {

    val petState = viewModel.pet.observeAsState(initial = Pet()).value
    val selectedRadioValueState = viewModel.selectedRadioValue.observeAsState(initial = 1).value
    val healthRecordTypeState = viewModel.healthRecordType.observeAsState(initial = "EXAME").value
    val dateState = viewModel.date.observeAsState(initial = "").value
    val timeState = viewModel.time.observeAsState(initial = "").value
    val descriptionState = viewModel.description.observeAsState(initial = "").value
    val healthRecordListState =
        viewModel.healthRecordList.observeAsState(initial = emptyList()).value


    viewModel.getPet(petId) {}
    viewModel.getHealthRecordList(petId) {}
    viewModel.getCurrentDate()
    viewModel.getCurrentTime()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white))
        ) {
            StandardHeader(
                onClick = {
                    navController.navigate("home/$userId")
                }
            )
            ScreenTitle(title = "MINHA SAÚDE")

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                PetSelector(action = { /*TODO*/ }, pet = petState, selected = petState.id)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = petState.name,
                    fontFamily = RobotoBold,
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.pethub_main_blue)
                )
            }

            // NOVO CADASTRO
            Column(
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 32.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Novo histórico de saúde:",
                        fontFamily = RobotoBold,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.pethub_main_blue)
                    )
                }


                // RADIO BUTTONS
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    StandardRadioButton(
                        radioValue = 1,
                        selectedValue = selectedRadioValueState,
                        text = "Exame"
                    ) {
                        viewModel.onSelectedRadioValueChanged(1)
                        viewModel.onHealthRecordTypeChanged()
                    }
                    StandardRadioButton(
                        radioValue = 2,
                        selectedValue = selectedRadioValueState,
                        text = "Imunização"
                    ) {
                        viewModel.onSelectedRadioValueChanged(2)
                        viewModel.onHealthRecordTypeChanged()
                    }
                    StandardRadioButton(
                        radioValue = 3,
                        selectedValue = selectedRadioValueState,
                        text = "Medicação"
                    ) {
                        viewModel.onSelectedRadioValueChanged(3)
                        viewModel.onHealthRecordTypeChanged()
                    }
                }

                // DATE AND HOUR
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.calendar_icon),
                        contentDescription = "calendar icon",
                        tint = colorResource(id = R.color.pethub_main_blue),
                        modifier = Modifier
                            .size(32.dp)
                            .padding(end = 4.dp),
                    )
                    Text(
                        text = dateState,
                        color = colorResource(id = R.color.pethub_main_blue),
                        fontSize = 18.sp,
                        fontFamily = RobotoThin,
                        fontWeight = FontWeight(1000)
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.time_icon),
                        contentDescription = "time icon",
                        tint = colorResource(id = R.color.pethub_main_blue),
                        modifier = Modifier
                            .size(32.dp)
                            .padding(end = 2.dp)
                    )
                    Text(
                        text = timeState,
                        color = colorResource(id = R.color.pethub_main_blue),
                        fontSize = 18.sp,
                        fontFamily = RobotoThin,
                        fontWeight = FontWeight(1000)
                    )
                }

                // INPUT
                Spacer(modifier = Modifier.height(22.dp))
                StandardInput(
                    value = descriptionState,
                    placeHolder = "Descrição: "
                ) { viewModel.onDescriptionChanged(it) }

                // SINAIS CLÍNICOS
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Sinais Clínicos:",
                        fontFamily = RobotoThin,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(800),
                        color = colorResource(id = R.color.pethub_main_blue)
                    )
                }

                // ADICIONAR
                Spacer(modifier = Modifier.height(18.dp))
                StandardButton(text = "Adicionar") {
                    viewModel.registerHealthRecord(petId) {}
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.pethub_main_blue))
            ) {
                Text(
                    text = "Diagnóstico",
                    color = colorResource(id = R.color.white)
                )
                if (healthRecordListState.isEmpty()) {
                    Text(
                        text = "Não existe cadastro do histórico de saúde para esse animal!",
                        fontFamily = RobotoBold,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.white),
                    )
                } else
                    Text(
                        text = healthRecordListState[0].description,
                        fontFamily = RobotoBold,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.white),
                    )
            }
        }


    }
}