package com.ads.pethub.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ads.pethub.R

@Composable
fun PetBirthdayContainer() {
    Row(
        modifier = Modifier
            .height(160.dp)
            .fillMaxWidth()
            .background(colorResource(id = R.color.pethub_main_blue))
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxHeight().padding(horizontal = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.balloons_icon),
                contentDescription = "balloons icon",
                modifier = Modifier.size(36.dp),
            )
        }
        PetBirthdayPortrait(
            image = painterResource(id = R.drawable.dog2_placeholder),
            petName = "Simba"
        )
        PetBirthdayPortrait(
            image = painterResource(id = R.drawable.dog4_placeholder),
            petName = "Legoshi"
        )
        PetBirthdayPortrait(
            image = painterResource(id = R.drawable.cat2_placeholder),
            petName = "Barbie"
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxHeight().padding(horizontal = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.balloons_icon),
                contentDescription = "balloons icon",
                modifier = Modifier.size(36.dp),
            )
        }
    }
}

@Preview
@Composable
fun PetBirthdayContainerPreview() {
    PetBirthdayContainer()
}