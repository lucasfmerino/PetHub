package com.ads.pethub.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ads.pethub.R

@Composable
fun LoginInput(
    username: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = username,
        onValueChange = onValueChange,
        placeholder = { Text(text = "Nome de usuário") },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done),
        colors = OutlinedTextFieldDefaults
            .colors(
                focusedBorderColor = colorResource(id = R.color.pethub_main_blue),
                unfocusedBorderColor = Color.Transparent,
                unfocusedContainerColor = colorResource(id = R.color.white),
                focusedContainerColor = colorResource(id = R.color.white),
                unfocusedPlaceholderColor = colorResource(id = R.color.pethub_main_gray),
                focusedPlaceholderColor = colorResource(id = R.color.pethub_main_gray),
                focusedTextColor = colorResource(id = R.color.pethub_main_gray),
                unfocusedTextColor = colorResource(id = R.color.pethub_main_gray),
                focusedTrailingIconColor = colorResource(id = R.color.pethub_main_gray),
                unfocusedTrailingIconColor = colorResource(id = R.color.pethub_main_gray)
            )
    )
}

@Preview
@Composable
fun LoginInputPreview() {
    LoginInput( "") {}
}