package com.apui.pregnancyvitaltracker.ui.vitalinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apui.pregnancyvitaltracker.data.model.VitalRecordEntity
import com.apui.pregnancyvitaltracker.domain.usecase.VitalDatabaseUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class VitalInfoViewModel(private val vitalDatabaseUseCase: VitalDatabaseUseCase) : ViewModel() {
    private val _vitalItems = MutableStateFlow<List<VitalRecordEntity>>(emptyList())
    val vitalItems: StateFlow<List<VitalRecordEntity>> = _vitalItems

    fun insertItem(vitalRecordEntity: VitalRecordEntity) {
        viewModelScope.launch {
            vitalDatabaseUseCase.insertVitalRecord(vitalRecordEntity)
        }
    }

    init {
        getAllItems()
    }

    private fun getAllItems() {
        viewModelScope.launch {
            vitalDatabaseUseCase().collectLatest { records ->
                _vitalItems.value = records
            }
        }
    }
}