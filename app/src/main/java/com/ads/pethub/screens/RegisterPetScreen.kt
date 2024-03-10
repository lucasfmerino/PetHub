package com.ads.pethub.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ads.pethub.R
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardButton
import com.ads.pethub.components.StandardHeader
import com.ads.pethub.components.StandardInput

@Composable
fun RegisterPetScreen(
    navController: NavController,
    userId: Int
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            StandardHeader(onClick = { navController.navigate("home") })
            ScreenTitle(title = "CADASTRAR PET")
            IconButton(onClick = {}, modifier = Modifier.size(90.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.photo_icon),
                    contentDescription = "Photo Icon",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(360.dp)
                        .padding(vertical = 16.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    items(1) {
                        StandardInput(value = "", placeHolder = "Name:")
                        StandardInput(value = "", placeHolder = "Birthdate:")
                        StandardInput(value = "", placeHolder = "Type:")
                        StandardInput(value = "", placeHolder = "Breed:")
                        StandardInput(value = "", placeHolder = "Color:")
                        StandardInput(value = "", placeHolder = "Sex:")
                        StandardInput(value = "", placeHolder = "Microchip Number:")
                        StandardInput(value = "", placeHolder = "Friendly:")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                StandardButton(text = "Add") {}
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
