package com.ads.pethub.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ads.pethub.R

@Composable
fun PasswordInput(
    isVisible: Boolean,
    password: String,
    onValueChange: (String) -> Unit,
    isVisibleChange: () -> Unit
) {

    val visibleIcon: Painter = if (isVisible)
        painterResource(id = R.drawable.visible_icon) else
        painterResource(id = R.drawable.not_visible_icon)

    OutlinedTextField(
        value = password,
        onValueChange = onValueChange,
        placeholder = { Text(text = "Senha") },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            IconButton(onClick = isVisibleChange) {
                Icon(
                    painter = visibleIcon,
                    contentDescription = "visibility icon"
                )
            }
        },
        visualTransformation = if (isVisible)
            VisualTransformation.None else
            PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
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
fun PasswordInputPreview() {
    PasswordInput(true, "", {}, {})
}