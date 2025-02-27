package com.apui.pregnancyvitaltracker.utils

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    TopAppBar(
        title = {Text("Track My Pregnancy")},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFFFC0CB),
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}