package com.ads.pethub.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.ui.theme.RobotoRegular
import com.ads.pethub.ui.theme.RobotoThin

@Composable
fun MissingPetCard(
    petName: String,
    date: String,
    time: String,
    address: String,
    number: String,
    neighborhood: String,
    city: String,
    state: String,
    cardAction: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(156.dp)
            .clickable { cardAction() },
        colors = CardDefaults.cardColors(
        ),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.pethub_main_blue)),

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .width(156.dp),
                    painter = painterResource(id = R.drawable.dog_placeholder),
                    contentDescription = "Dog placeholder",
                    contentScale = ContentScale.FillWidth,
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(22.dp)
                        .padding(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.info_icon),
                        contentDescription = "info Icon",
                        tint = colorResource(id = R.color.white)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.pethub_main_blue))
                        .padding(2.dp)
                        .align(Alignment.BottomCenter),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = petName,
                        color = Color.White,
                        fontFamily = RobotoRegular,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Row(
                modifier = Modifier
                    .width(100.dp)
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    text = "Desaparecimento reportado em:",
                    fontFamily = RobotoRegular,
                    fontSize = 10.sp,
                    color = colorResource(id = R.color.pethub_main_blue),
                    textAlign = TextAlign.Center
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.calendar_icon),
                    contentDescription = "calendar icon",
                    tint = colorResource(id = R.color.pethub_main_blue),
                    modifier = Modifier
                        .size(16.dp)
                        .padding(end = 2.dp),
                )
                Text(
                    text = date,
                    color = colorResource(id = R.color.pethub_main_blue),
                    fontSize = 10.sp,
                    fontFamily = RobotoThin,
                    fontWeight = FontWeight(1000)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    painter = painterResource(id = R.drawable.time_icon),
                    contentDescription = "time icon",
                    tint = colorResource(id = R.color.pethub_main_blue),
                    modifier = Modifier
                        .size(16.dp)
                        .padding(end = 2.dp)
                )
                Text(
                    text = time,
                    color = colorResource(id = R.color.pethub_main_blue),
                    fontSize = 10.sp,
                    fontFamily = RobotoThin,
                    fontWeight = FontWeight(1000)
                )
            }
            Row(
                modifier = Modifier
                    .padding(vertical = 6.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.location_icon),
                    contentDescription = "location icon",
                    tint = colorResource(id = R.color.pethub_main_blue),
                    modifier = Modifier
                        .size(16.dp)
                        .padding(end = 2.dp)
                )
                Text(
                    text = "Nas proximidades de:",
                    color = colorResource(id = R.color.pethub_main_blue),
                    fontSize = 11.sp,
                    fontFamily = RobotoRegular,
                    fontWeight = FontWeight(10)
                )
            }
            Column (
                modifier = Modifier
                    .padding(bottom = 10.dp)
            ) {
                Text(
                    text = "$address, $number",
                    color = colorResource(id = R.color.pethub_main_blue),
                    fontSize = 10.sp,
                    fontFamily = RobotoThin,
                    fontWeight = FontWeight(1000)
                )
                Text(
                    text = neighborhood,
                    color = colorResource(id = R.color.pethub_main_blue),
                    fontSize = 10.sp,
                    fontFamily = RobotoThin,
                    fontWeight = FontWeight(1000)
                )
                Text(
                    text = "$city - $state",
                    color = colorResource(id = R.color.pethub_main_blue),
                    fontSize = 10.sp,
                    fontFamily = RobotoThin,
                    fontWeight = FontWeight(1000)
                )
            }

        }


    }
}

@Preview
@Composable
fun MissingPetCardPreview() {
    MissingPetCard(
        petName = "Átila",
        date = "10/03/2024",
        time = "19h30",
        address = "Av. Cruzeiro do Sul",
        number = "1800",
        neighborhood = "Santana",
        city =  "São Paulo",
        state = "SP"
    ) {}
}