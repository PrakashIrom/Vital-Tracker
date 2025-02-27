package com.apui.pregnancyvitaltracker.utils

import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogBox(
    onDismiss:()-> Unit,
    onConfirm: () -> Unit,
    title: String,
    dialogContent: @Composable () -> Unit,
){
    BasicAlertDialog(
        onDismissRequest = onDismiss,
        modifier = Modifier,
    ){
      dialogContent()
    }
}