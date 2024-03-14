package com.ads.pethub.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ads.pethub.R

@Composable
fun NavMenu(
    action1: () -> Unit,
    action2: () -> Unit,
    action3: () -> Unit,
    action4: () -> Unit,
    action5: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.pethub_main_blue)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        MenuIcon(
            painter = painterResource(id = R.drawable.user_icon),
            contentDescription = "User icon",
            text = "Meus Dados",
            action = action1
        )
        MenuIcon(
            painter = painterResource(id = R.drawable.register_pet),
            contentDescription = "New pet icon",
            text = "Novo Pet",
            action = action2
        )
        MenuIcon(
            painter = painterResource(id = R.drawable.pet_profile),
            contentDescription = "Pet profile icon",
            text = "Perfil do Pet",
            action = action3
        )
        MenuIcon(
            painter = painterResource(id = R.drawable.pet_finder),
            contentDescription = "Pet finder icon",
            text = "Pet Finder",
            action = action4
        )
        MenuIcon(
            painter = painterResource(id = R.drawable.health_care),
            contentDescription = "Health care icon",
            text = "Saúde do Pet",
            action = action5
        )
    }
}

@Preview
@Composable
fun NavMenuPreview() {
    NavMenu({},{},{},{},{})
}