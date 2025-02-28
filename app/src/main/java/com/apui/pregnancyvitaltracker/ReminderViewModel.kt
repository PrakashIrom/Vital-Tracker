package com.apui.pregnancyvitaltracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.apui.pregnancyvitaltracker.domain.usecase.ScheduleReminderUseCase

class ReminderViewModel(
    application: Application,
    private val scheduleReminderUseCase: ScheduleReminderUseCase
) :
    AndroidViewModel(application) {
    private val workManager = WorkManager.getInstance(application.applicationContext)

    fun observeWorkStatus(lifecycleOwner: LifecycleOwner) {
        workManager.getWorkInfosForUniqueWorkLiveData("VitalReminder")
            .observe(lifecycleOwner) { workInfos ->
                val isScheduled =
                    workInfos.any { it.state == WorkInfo.State.ENQUEUED || it.state == WorkInfo.State.RUNNING }
                if (!isScheduled) {
                    scheduleReminderUseCase()
                }
            }
    }
}