package com.ads.pethub.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.ui.theme.RobotoRegular

@Composable
fun StandardRadioButton(
    radioValue: Int,
    selectedValue: Int,
    text: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            RadioButton(
                selected = selectedValue == radioValue,
                onClick = onClick,
                colors = RadioButtonDefaults.colors(
                    selectedColor = colorResource(id = R.color.pethub_main_blue),
                    unselectedColor = colorResource(id = R.color.pethub_main_blue)
                ),
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Text(
                text = text,
                fontFamily = RobotoRegular,
                fontSize = 14.sp,
                color = colorResource(id = R.color.pethub_main_blue),
                modifier = Modifier.padding(start = 40.dp)
            )
        }
    }
}

@Preview
@Composable
fun StandardRadioButtonPreview() {
    StandardRadioButton(2,1, "Imunização") {}
}