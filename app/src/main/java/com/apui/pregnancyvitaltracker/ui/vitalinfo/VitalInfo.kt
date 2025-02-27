package com.apui.pregnancyvitaltracker.ui.vitalinfo

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun VitalInfo(viewModel: VitalInfoViewModel = koinViewModel(),
              paddingValues: PaddingValues
              ){

    val vitalItems = viewModel.vitalItems.collectAsStateWithLifecycle().value

    LazyColumn(modifier = Modifier.padding(150.dp)) {
        items(vitalItems.size){ index ->
            Text(vitalItems[index].bloodPressure)
            Text(vitalItems[index].weight.toString())
            Text(vitalItems[index].babyKicks.toString())
            Text(vitalItems[index].heartRate.toString())
        }
    }
}