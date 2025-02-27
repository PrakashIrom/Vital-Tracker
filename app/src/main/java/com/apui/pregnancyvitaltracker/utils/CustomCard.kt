package com.apui.pregnancyvitaltracker.utils

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Card(modifier = modifier) {
        content()
    }
}