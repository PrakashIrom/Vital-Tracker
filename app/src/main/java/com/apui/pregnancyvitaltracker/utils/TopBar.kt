package com.apui.pregnancyvitaltracker.utils

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                "Track My Pregnancy",
                fontWeight = FontWeight.W600,
                color = Color(0xFF5F1C9C)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFC8ADFC),
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}