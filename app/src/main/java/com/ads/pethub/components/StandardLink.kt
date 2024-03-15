package com.ads.pethub.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.OutlinedButton
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
fun StandardLink(
    text: String,
    fontSize: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.clickable { onClick() }
    ) {
        Text(
            text = text,
            color = colorResource(id = R.color.pethub_main_blue),
            fontSize = fontSize.sp,
            fontFamily = RobotoBold
        )
    }
}

@Preview
@Composable
fun StandardLinkPreview() {
    StandardLink("Clique Aqui!", 12){ }
}
