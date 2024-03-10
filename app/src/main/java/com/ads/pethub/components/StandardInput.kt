package com.ads.pethub.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.ui.theme.RobotoRegular

@Composable
fun StandardInput(
    value: String,
    placeHolder: String,
    updateValue: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = updateValue,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        placeholder = {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp),
                text = placeHolder,
                fontFamily = RobotoRegular,
                fontSize = 16.sp,
                color = colorResource(id = R.color.pethub_main_gray)
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = colorResource(id = R.color.pethub_light_gray),
            unfocusedBorderColor = colorResource(id = R.color.pethub_light_gray)
        ),
        shape = RoundedCornerShape(10.dp)
    )
    Spacer(modifier = Modifier.height(12.dp))
}

@Preview
@Composable
fun StandardInputPreview() {
    StandardInput("", "Name: ", {})
}