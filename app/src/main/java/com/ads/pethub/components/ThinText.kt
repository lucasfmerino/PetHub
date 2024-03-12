package com.ads.pethub.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.ui.theme.RobotoThin

@Composable
fun ThinText(
    text: String,
    fontSize: Int
) {
    Text(
        text = text,
        color = colorResource(id = R.color.pethub_main_blue),
        fontFamily = RobotoThin,
        fontSize = fontSize.sp,
        fontWeight = FontWeight(800)
    )
}

@Preview
@Composable
fun ThinTextPreview() {
    ThinText("Texto",14)
}