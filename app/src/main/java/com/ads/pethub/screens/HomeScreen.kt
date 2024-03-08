package com.ads.pethub.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.ads.pethub.components.StandardHeader

@Composable
fun HomeScreen() {

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            StandardHeader()
        }
    }

}