package com.ads.pethub.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ads.pethub.R
import com.ads.pethub.model.Pet

@Composable
fun PetSelector(
    action: () -> Unit,
    pet: Pet,
    selected: Boolean
) {

    val petPortrait: Painter = when (pet.petSpecies) {
        "Cachorro" -> painterResource(id = R.drawable.dog2_placeholder)
        "Gato" -> painterResource(id = R.drawable.cat_placeholder)
        else -> painterResource(id = R.drawable.dog_placeholder)
    }

    val borderStroke: Int = if (selected) 3 else 0

    Card(
        modifier = Modifier
            .size(64.dp)
            .clickable { action() },
        shape = CircleShape,
        border = BorderStroke(width = borderStroke.dp, colorResource(id = R.color.pethub_main_blue))
    ) {
        Image(
            painter = petPortrait,
            contentDescription = "pet portrait",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun PetSelectorPreview() {
    PetSelector(
        pet = Pet(
            id = 2,
            name = "",
            scientificName = "",
            petSpecies = "Gato",
            chipCode = "",
            tattooCode = "",
            birthdate = "",
            petSize = "",
            weight = "",
            friendly = "",
            breed = "",
            photograph = ""
        ),
        selected = true,
        action = {}
    )
}