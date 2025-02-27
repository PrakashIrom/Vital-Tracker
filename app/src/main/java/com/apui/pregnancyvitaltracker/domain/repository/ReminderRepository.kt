package com.apui.pregnancyvitaltracker.domain.repository

interface ReminderRepository {
    fun scheduleReminder()
    fun cancelReminder()
}