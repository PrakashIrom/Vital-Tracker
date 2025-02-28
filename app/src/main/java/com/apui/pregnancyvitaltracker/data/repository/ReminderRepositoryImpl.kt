package com.apui.pregnancyvitaltracker.data.repository

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.apui.pregnancyvitaltracker.domain.repository.ReminderRepository
import com.apui.pregnancyvitaltracker.worker.ReminderWorker
import java.util.concurrent.TimeUnit


class ReminderRepositoryImpl(private val context: Context) : ReminderRepository {

    override fun scheduleReminder() {
        val workRequest = PeriodicWorkRequestBuilder<ReminderWorker>(15, TimeUnit.MINUTES)
            .setConstraints(
                Constraints.Builder()
                    .setRequiresBatteryNotLow(true)
                    .setRequiresCharging(false)
                    .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                    .build()
            )
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "VitalReminder",
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )

    }

    override fun cancelReminder() {
        WorkManager.getInstance(context).cancelUniqueWork("VitalReminder")
    }
}