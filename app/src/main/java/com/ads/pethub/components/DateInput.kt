package com.ads.pethub.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DateInput(
    value: String,
    placeHolder: String,
    updateValue: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            val filtered = newValue.filter { it.isDigit() }
            if (filtered.length <= 8) {
                updateValue(filtered)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        placeholder = {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp),
                text = placeHolder,
                fontSize = 16.sp,
                color = colorResource(id = R.color.pethub_main_gray)
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = colorResource(id = R.color.pethub_light_gray),
            unfocusedBorderColor = colorResource(id = R.color.pethub_light_gray)
        ),
        shape = RoundedCornerShape(10.dp),
        visualTransformation = dateVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        )
    )
    Spacer(modifier = Modifier.height(12.dp))
}

fun dateVisualTransformation(): VisualTransformation = VisualTransformation { source ->

    val out = StringBuilder()
    for (i in source.indices) {

        out.append(source[i])

        if (i == 1 || i == 3) out.append("/")
    }
    val result = AnnotatedString(out.toString())

    object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {

            return when {
                offset <= 2 -> offset
                offset <= 4 -> offset + 1
                offset <= 6 -> offset + 2
                else -> offset + 2
            }
        }

        override fun transformedToOriginal(offset: Int): Int {

            return when {
                offset <= 2 -> offset
                offset <= 5 -> offset - 1
                offset <= 8 -> offset - 2
                else -> offset - 2
            }
        }
    }.let { offsetMapping -> TransformedText(result, offsetMapping) }
}

@Preview
@Composable
fun DateInputPreview() {
    DateInput("01012021", "Digite a data (DD/MM/AAAA): ") {}
}
