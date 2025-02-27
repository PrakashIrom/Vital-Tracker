package com.apui.pregnancyvitaltracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.apui.pregnancyvitaltracker.domain.usecase.ScheduleReminderUseCase

class ReminderViewModel(
    application: Application,
    private val scheduleReminderUseCase: ScheduleReminderUseCase
) :
    AndroidViewModel(application) {
    init {
        scheduleReminder()
    }

    private fun scheduleReminder() {
        scheduleReminderIfNeeded()
    }

    private fun scheduleReminderIfNeeded() {
        WorkManager.getInstance(getApplication<Application>().applicationContext)
            .getWorkInfosForUniqueWorkLiveData("VitalReminder")
            .observeForever { workInfos ->
                val isScheduled = workInfos.any {
                    it.state == WorkInfo.State.ENQUEUED || it.state == WorkInfo.State.RUNNING
                }
                if (!isScheduled) {
                    scheduleReminderUseCase()
                }
            }
    }
}