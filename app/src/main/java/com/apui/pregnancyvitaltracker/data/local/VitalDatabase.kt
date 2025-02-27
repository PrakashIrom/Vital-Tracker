package com.apui.pregnancyvitaltracker.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.apui.pregnancyvitaltracker.data.model.VitalRecordEntity

@Database(entities = [VitalRecordEntity::class], version = 1, exportSchema = false)
abstract class VitalDatabase : RoomDatabase() {

    abstract fun itemDao(): VitalDao

    companion object {
        @Volatile
        private var Instance: VitalDatabase? = null

        fun getDatabase(context: Context): VitalDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, VitalDatabase::class.java, "vital_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}