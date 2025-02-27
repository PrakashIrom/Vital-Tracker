package com.apui.pregnancyvitaltracker.ui.vitalinfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.apui.pregnancyvitaltracker.R
import com.apui.pregnancyvitaltracker.utils.CustomCard
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun VitalInfo(
    viewModel: VitalInfoViewModel = koinViewModel(),
) {
    val vitalItems = viewModel.vitalItems.collectAsStateWithLifecycle().value

    LazyColumn(
        modifier = Modifier
            .padding(
                top = 100.dp,
                start = 10.dp,
                end = 10.dp,
                bottom = 10.dp
            )
    ) {
        items(vitalItems) { vitalItem ->
            CustomCard(
                modifier = Modifier
                    .padding(vertical = 11.dp, horizontal = 11.dp)
                    .fillMaxWidth(),
                timeStamp = vitalItem.timestamp
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 13.dp, top = 14.dp, end = 13.dp, bottom = 14.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        VitalItem(
                            icon = R.drawable.heart_rate,
                            label = "Heart Rate",
                            value = vitalItem.heartRate.toString()
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        VitalItem(
                            icon = R.drawable.blood_pressure,
                            label = "Blood Pressure",
                            value = vitalItem.bloodPressure
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        VitalItem(
                            icon = R.drawable.scale,
                            label = "Weight",
                            value = vitalItem.weight.toString()
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        VitalItem(
                            icon = R.drawable.newborn,
                            label = "Baby Kicks",
                            value = vitalItem.babyKicks.toString()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun VitalItem(
    icon: Int,
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = label,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = value,
            color = Color(0xFF3F0A71),
            fontWeight = FontWeight.W600,
        )
    }
}