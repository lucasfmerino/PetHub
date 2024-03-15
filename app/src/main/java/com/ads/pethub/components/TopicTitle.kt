package com.ads.pethub.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.ui.theme.RobotoBold
import com.ads.pethub.ui.theme.RobotoRegular

@Composable
fun TopicTitle(
    painter: Painter,
    topic: String
) {
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painter,
            contentDescription = "Topic Icon",
            tint = colorResource(id = R.color.pethub_main_blue),
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = topic,
            color = colorResource(id = R.color.pethub_main_gray),
            fontFamily = RobotoRegular,
            fontSize = 14.sp,
            fontWeight = FontWeight(600)
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Preview
@Composable
fun TopicTitlePreview() {
    TopicTitle(
        painter = painterResource(id = R.drawable.pet_finder),
        topic = "NOVOS DESAPARECIMENTOS REPORTADOS"
    )
}