package com.ads.pethub.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ads.pethub.R
import com.ads.pethub.model.HealthRecord
import com.ads.pethub.ui.theme.RobotoRegular


@Composable
fun HealthRecordCarousel(
    healthRecords: List<HealthRecord>,
    currentIndex: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    formattedDate: () -> String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
        ) {
        LazyRow(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center) {
            itemsIndexed(healthRecords) { index, healthRecord ->
                if (index == currentIndex) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                        IconButton(onClick = onPreviousClick) {
                            if (currentIndex == 0) {
                                Icon(
                                    painter = painterResource(id = R.drawable.previous_icon),
                                    contentDescription = "Previous Icon ",
                                    tint = colorResource(id = R.color.pethub_main_gray)
                                )
                            } else {
                                Icon(
                                    painter = painterResource(id = R.drawable.previous_icon),
                                    contentDescription = "Previous Icon ",
                                    tint = colorResource(id = R.color.white)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = formattedDate(),
                                color = colorResource(id = R.color.white),
                                fontFamily = RobotoRegular,
                                fontSize = 18.sp,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = healthRecord.description,
                                color = colorResource(id = R.color.white),
                                fontFamily = RobotoRegular,
                                fontSize = 16.sp,
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(onClick = onNextClick) {
                            if (currentIndex == healthRecords.size -1) {
                                Icon(
                                    painter = painterResource(id = R.drawable.next_icon),
                                    contentDescription = "Next Icon",
                                    tint = colorResource(id = R.color.pethub_main_gray)
                                )
                            } else {
                                Icon(
                                    painter = painterResource(id = R.drawable.next_icon),
                                    contentDescription = "Next Icon",
                                    tint = colorResource(id = R.color.white)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun HealthRecordCarouselPreview() {
    HealthRecordCarousel(emptyList(), 0, {}, {}, {" "})
}
