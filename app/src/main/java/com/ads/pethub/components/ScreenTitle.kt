package com.ads.pethub.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.ui.theme.RobotoBold

@Composable
fun ScreenTitle(
    title: String
) {
    Box(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            color = colorResource(id = R.color.pethub_main_blue),
            fontFamily = RobotoBold,
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
fun ScreenTitlePreview() {
    ScreenTitle("Title Preview")
}