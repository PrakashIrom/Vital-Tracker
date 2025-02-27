package com.apui.pregnancyvitaltracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vital_records")
data class VitalRecordEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bloodPressure: String,
    val heartRate: Int,
    val weight: Float,
    val babyKicks: Int,
    val timestamp: Long
)
