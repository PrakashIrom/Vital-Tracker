package com.apui.pregnancyvitaltracker.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apui.pregnancyvitaltracker.data.model.VitalRecordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalDao {
    @Query("SELECT * FROM vital_records ORDER BY timestamp DESC")
    fun getAllVitalRecords(): Flow<List<VitalRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVitalRecord(record: VitalRecordEntity)
}