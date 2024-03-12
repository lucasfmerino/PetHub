package com.ads.pethub.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.ui.theme.RobotoBold

@Composable
fun StandardButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.pethub_main_blue)
        ),
    ) {
        Text(
            text = text,
            fontFamily = RobotoBold,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
fun StandardButtonPreview() {
    StandardButton("Action") { }
}