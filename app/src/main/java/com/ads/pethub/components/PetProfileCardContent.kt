package com.ads.pethub.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.ads.pethub.ui.theme.RobotoBold
import com.ads.pethub.ui.theme.RobotoRegular
import com.ads.pethub.ui.theme.RobotoThin

@Composable
fun PetProfileCardContent(
    petDescription: String,
    petName: String,
    petAge: String,
    petType: String,
    petBreed: String,
    petColor: String,
    petGender: String,
    microchip: String,
    petFriendly: String
) {
    val description = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.pethub_main_blue),
                fontFamily = RobotoBold,
                fontSize = 12.sp,
            )
        ) {
            append("Description:  ")
        }
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.pethub_main_blue),
                fontFamily = RobotoThin,
                fontSize = 12.sp,
                fontWeight = FontWeight(800)
            )
        ) {
            append(petDescription)
        }
    }
    Column(
        modifier = Modifier
            .padding(horizontal = 48.dp, vertical = 24.dp)
    ) {
        Text(
            text = petName,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(id = R.color.pethub_main_blue),
            fontFamily = RobotoBold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        ThinText(petAge, 14)
        ThinText(petType, 14)
        ThinText(petBreed, 14)
        ThinText(petColor, 14)
        ThinText(petGender, 14)
        Row {
            ThinText("Microchip N.º  ", 14)
            Text(
                text = microchip,
                color = colorResource(id = R.color.pethub_main_blue),
                fontFamily = RobotoRegular,
                fontSize = 14.sp,
                fontWeight = FontWeight(800)
            )
        }
        Row {
            ThinText("Friendly  ", 14)
            Text(
                text = petFriendly,
                color = colorResource(id = R.color.pethub_main_blue),
                fontFamily = RobotoRegular,
                fontSize = 14.sp,
                fontWeight = FontWeight(800)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = description)
    }
}

@Preview
@Composable
fun PetProfileCardContentPreview() {
    PetProfileCardContent(
        petDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor" +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis" +
                "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu" +
                "fugiat nulla pariatur. ",
        petName = "",
        petType = "",
        petAge = "",
        petBreed = "",
        petColor = "",
        petGender = "",
        microchip = "",
        petFriendly = "",
    )
}