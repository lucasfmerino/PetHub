package com.ads.pethub.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.ui.theme.RobotoBold
import com.ads.pethub.ui.theme.RobotoThin

@Composable
fun PetOwnersCard(
    ownerName: String,
    phone: String,
    email: String,
    action: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.pethub_main_blue))
    ) {
        Column(
            modifier = Modifier
                .padding(start = 32.dp, end = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "PET OWNERS:",
                    color = Color.White,
                    fontFamily = RobotoBold,
                    fontSize = 14.sp
                )
                IconButton(
                    onClick = action,
                    modifier = Modifier.padding(0.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.warning_icon),
                        contentDescription = "warning icon",
                        tint = Color.White
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = ownerName,
                    color = Color.White,
                    fontFamily = RobotoThin,
                    fontWeight = FontWeight(1000)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.whatsapp_icon),
                    contentDescription = "whatsapp icon",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(18.dp)
                )
                Text(
                    text = phone,
                    color = Color.White,
                    fontFamily = RobotoThin,
                    fontWeight = FontWeight(800)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.email_icon),
                    contentDescription = "e-mail icon",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(18.dp)
                )
                Text(
                    text = email,
                    color = Color.White,
                    fontFamily = RobotoThin,
                    fontWeight = FontWeight(800)
                )
            }

        }
    }

}

@Preview
@Composable
fun PetOwnersCardPreview() {
    PetOwnersCard(
        "Fulano da Sailva",
        "+55 (11) 98509-1275",
        "fulanodasilva@email.com"
    ) {}
}