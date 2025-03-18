package com.apui.pregnancyvitaltracker.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.apui.pregnancyvitaltracker.data.model.VitalRecordEntity
import com.apui.pregnancyvitaltracker.ui.vitalinfo.VitalInfo
import com.apui.pregnancyvitaltracker.ui.vitalinfo.VitalInfoViewModel
import com.apui.pregnancyvitaltracker.utils.CustomButton
import com.apui.pregnancyvitaltracker.utils.CustomCard
import com.apui.pregnancyvitaltracker.utils.DialogBox
import com.apui.pregnancyvitaltracker.utils.OutlineTextField
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(
    showDialogBox: MutableState<Boolean>, innerPadding: PaddingValues,
    viewModel: VitalInfoViewModel = koinViewModel()
) {

    val sysBp = remember { mutableStateOf("") }
    val diaBp = remember { mutableStateOf("") }
    val weight = remember { mutableStateOf("") }
    val babyKicks = remember { mutableStateOf("") }

    VitalInfo()

    if (showDialogBox.value) {
        DialogBox(
            onDismiss = { showDialogBox.value = false },
            onConfirm = { showDialogBox.value = false },
            title = "Add Vitals"
        ) {
            CustomCard(color = Color(0xFFFFFFFF)) {
                Column(
                    modifier = Modifier.padding(16.dp),
                ) {
                    Text(
                        "Add Vitals",
                        modifier = Modifier.align(Alignment.Start),
                        color = Color(0xFF3F0A71),
                        fontWeight = FontWeight.W600
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        OutlineTextField(
                            value = sysBp.value,
                            onValueChange = {
                                if (it.all { char -> char.isDigit() }) {
                                    sysBp.value = it
                                }
                            },
                            label = "Sys BP",
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        OutlineTextField(
                            value = diaBp.value,
                            onValueChange = {
                                if (it.all { char -> char.isDigit() }) {
                                    diaBp.value = it
                                }
                            },
                            label = "Dia BP",
                            modifier = Modifier.weight(1f)
                        )
                    }
                    OutlineTextField(
                        value = weight.value,
                        onValueChange = {
                            if (it.all { char -> char.isDigit() }) {
                                weight.value = it
                            }
                        },
                        label = "Weight (in Kg)",
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlineTextField(
                        value = babyKicks.value,
                        onValueChange = {
                            if (it.all { char -> char.isDigit() }) {
                                babyKicks.value = it
                            }
                        },
                        label = "Baby Kicks",
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        val isValid = sysBp.value.isNotBlank() &&
                                diaBp.value.isNotBlank() &&
                                weight.value.toFloatOrNull() != null &&
                                babyKicks.value.toIntOrNull() != null

                        CustomButton(
                            onClick = {

                                showDialogBox.value = false
                                viewModel.insertItem(
                                    VitalRecordEntity(
                                        bloodPressure = "${sysBp.value}/${diaBp.value}",
                                        heartRate = 0,
                                        weight = weight.value.toFloat(),
                                        babyKicks = babyKicks.value.toInt(),
                                        timestamp = System.currentTimeMillis()
                                    )
                                )
                                sysBp.value = ""
                                diaBp.value = ""
                                weight.value = ""
                                babyKicks.value = ""
                            },
                            text = "Submit",
                            shape = RoundedCornerShape(10),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C4DB9)),
                            isEnabled = isValid
                        )
                    }
                }
            }
        }
    }
}