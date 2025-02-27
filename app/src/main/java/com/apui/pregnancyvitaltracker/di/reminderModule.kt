package com.apui.pregnancyvitaltracker.di

import android.app.Application
import com.apui.pregnancyvitaltracker.ReminderViewModel
import com.apui.pregnancyvitaltracker.data.repository.ReminderRepositoryImpl
import com.apui.pregnancyvitaltracker.domain.repository.ReminderRepository
import com.apui.pregnancyvitaltracker.domain.usecase.CancelReminderUseCase
import com.apui.pregnancyvitaltracker.domain.usecase.ScheduleReminderUseCase
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val reminderModule = module {
    single<ReminderRepository> { ReminderRepositoryImpl(get()) }
    single { ScheduleReminderUseCase(get()) }
    single { CancelReminderUseCase(get()) }
    viewModel { (application: Application) ->
        ReminderViewModel(application, get())
    }
}