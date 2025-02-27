package com.apui.pregnancyvitaltracker.domain.usecase

import com.apui.pregnancyvitaltracker.data.model.VitalRecordEntity
import com.apui.pregnancyvitaltracker.domain.repository.VitalRepository

class VitalDatabaseUseCase(private val vitalRepository: VitalRepository) {

    operator fun invoke() = vitalRepository.getAllVitalRecords()

    suspend fun insertVitalRecord(record: VitalRecordEntity) =
        vitalRepository.insertVitalRecord(record)
}