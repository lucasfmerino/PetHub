package com.ads.pethub.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.model.Pet
import com.ads.pethub.ui.theme.RobotoBold
import com.ads.pethub.ui.theme.RobotoRegular
import com.ads.pethub.ui.theme.RobotoThin

@Composable
fun PetUpdateInfo(
    pet: Pet
) {

    val cardText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.pethub_main_blue),
                fontFamily = RobotoRegular,
                fontSize = 13.sp,
            )
        ) {
            append("${pet.name}:  ")
        }
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.pethub_main_blue),
                fontFamily = RobotoThin,
                fontSize = 12.sp,
                fontWeight = FontWeight(800)
            )
        ) {
            append("Não há registros recentes")
        }
    }

    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        PetSelector(action = { /*TODO*/ }, pet = pet, selected = pet.id)

        OutlinedButton(
            modifier = Modifier.height(88.dp),
            onClick = { /*TODO*/ },
            border = BorderStroke(0.dp, Color(0x00FFFFFF)),

            ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = cardText)
                Text(
                    text = "Clique aqui para mais informações (DISABLED)",
                    textAlign = TextAlign.Left,
                    color = colorResource(id = R.color.pethub_main_gray),
                    fontFamily = RobotoRegular,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(800)
                )
            }
        }
    }
}


@Preview
@Composable
fun PetUpdateInfoPreview() {
    PetUpdateInfo(
        pet = Pet(
            id = 2,
            name = "Gato Maroto",
            scientificName = "",
            petSpecies = "Gato",
            chipCode = "",
            tattooCode = "",
            birthdate = "",
            petSize = "",
            weight = 0.0,
            friendly = "",
            breed = "",
        )
    )
}