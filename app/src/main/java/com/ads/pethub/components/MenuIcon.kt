package com.ads.pethub.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.ui.theme.RobotoThin

@Composable
fun MenuIcon(
    painter: Painter,
    contentDescription: String,
    text: String,
    action: () -> Unit

) {
    IconButton(
        onClick = action,
        modifier = Modifier
            .width(46.dp)
            .height(88.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painter,
                contentDescription = contentDescription,
                tint = Color.White
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = text,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = RobotoThin,
                fontWeight = FontWeight(800),
                fontSize = 12.sp
            )
        }
    }
}


@Preview
@Composable
fun MenuIconPreview() {
    MenuIcon(
        painter = painterResource(id = R.drawable.pet_profile),
        contentDescription = "Teste",
        text = "Perfil do Pet",
        action = {}
    )
}