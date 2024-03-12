package com.ads.pethub.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ads.pethub.components.ScreenTitle
import com.ads.pethub.components.StandardButton

@Composable
fun LoginScreen(
    navController: NavController,
) {

    val userId: Int = 1
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
//            StandardHeader(
//                onClick = { }
//            )
            ScreenTitle(title = "Login")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StandardButton(
                    text = "Login",
                    onClick = {
                        navController.navigate("${userId}/home")
                    }
                )
            }
        }
    }
}