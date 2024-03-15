package com.ads.pethub.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.ui.theme.RobotoBold
import com.ads.pethub.ui.theme.RobotoRegular

@Composable
fun PetBirthdayPortrait(
    image: Painter,
    petName: String
) {
    Column(
        modifier = Modifier.fillMaxHeight().padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.party_hat_icon),
            contentDescription = "Birthday Hat Icon",
            modifier = Modifier.size(26.dp),
        )
        Card(
            shape = CircleShape,
            modifier = Modifier
                .offset(y = -(4).dp)
                .width(72.dp)
                .height(72.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = image, contentDescription = "Pet Portrait",
                contentScale = ContentScale.FillHeight,
            )
        }
        Text(
            text = petName,
            color = Color.White,
            fontFamily = RobotoRegular,
            fontSize = 14.sp
        )
    }
}


@Preview
@Composable
fun PetBirthdayPortraitPreview() {
    PetBirthdayPortrait(
        image = painterResource(id = R.drawable.dog2_placeholder),
        petName = "Simba"
    )

}