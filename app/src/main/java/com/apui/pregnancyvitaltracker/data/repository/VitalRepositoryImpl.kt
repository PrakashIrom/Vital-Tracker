package com.apui.pregnancyvitaltracker.data.repository

import com.apui.pregnancyvitaltracker.data.local.VitalDao
import com.apui.pregnancyvitaltracker.data.model.VitalRecordEntity
import com.apui.pregnancyvitaltracker.domain.repository.VitalRepository
import kotlinx.coroutines.flow.Flow

class VitalRepositoryImpl(private val vitalDao: VitalDao) : VitalRepository {

    override fun getAllVitalRecords(): Flow<List<VitalRecordEntity>> = vitalDao.getAllVitalRecords()

    override suspend fun insertVitalRecord(record: VitalRecordEntity) {
        vitalDao.insertVitalRecord(record)
    }

}