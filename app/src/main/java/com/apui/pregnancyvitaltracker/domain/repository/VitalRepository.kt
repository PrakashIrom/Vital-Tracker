package com.apui.pregnancyvitaltracker.domain.repository

import com.apui.pregnancyvitaltracker.data.model.VitalRecordEntity
import kotlinx.coroutines.flow.Flow

interface VitalRepository {
    fun getAllVitalRecords(): Flow<List<VitalRecordEntity>>
    suspend fun insertVitalRecord(record: VitalRecordEntity)
}