package com.apui.pregnancyvitaltracker.domain.usecase

import com.apui.pregnancyvitaltracker.domain.repository.ReminderRepository

class ScheduleReminderUseCase(private val reminderRepository: ReminderRepository) {
    operator fun invoke() = reminderRepository.scheduleReminder()
}
