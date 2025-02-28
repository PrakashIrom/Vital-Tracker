package com.apui.pregnancyvitaltracker.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    timeStamp: Long = 0,
    color: Color,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = color),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box {
            Column(
                modifier = Modifier.padding(bottom = 27.dp)
            ) {
                content()
            }
            if (timeStamp.toInt() != 0)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(31.dp)
                        .background(
                            color = Color(0xFF9C4DB9),
                            shape = RoundedCornerShape(bottomEnd = 4.dp, bottomStart = 4.dp)
                        )
                        .align(Alignment.BottomCenter)
                ) {
                    Text(
                        timeStamp.formatTime(),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 5.dp)
                    )
                }
        }
    }
}
