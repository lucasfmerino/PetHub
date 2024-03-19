package com.ads.pethub.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.ui.theme.RobotoBold

@Composable
fun PetPortrait(
    petSpecies: String,
    edit: () -> Unit
) {

    val petPortrait: Painter = when (petSpecies.lowercase()) {
        "cachorro" -> painterResource(id = R.drawable.dog5_placeholder)
        "gato" -> painterResource(id = R.drawable.cat4_placeholder)
        else -> painterResource(id = R.drawable.pethub_logo)
    }

    Column {
        Box(
            contentAlignment = Alignment.TopEnd,
            modifier = Modifier
                .fillMaxWidth()
                .height(340.dp),
        ) {
            Image(
                painter = petPortrait,
                contentDescription = "Dog portrait",
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .width(56.dp)
                    .height(18.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = edit,
                    modifier = Modifier.fillMaxSize(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.pethub_main_blue)
                    ),
                    shape = RoundedCornerShape(4.dp),
                ) { }
                Text(
                    text = "Editar",
                    fontSize = 10.sp,
                    color = Color.White,
                    fontFamily = RobotoBold
                )
            }
        }
    }
}

@Preview
@Composable
fun PetPortraitPreview() {
    PetPortrait ("cachorro") {}
}