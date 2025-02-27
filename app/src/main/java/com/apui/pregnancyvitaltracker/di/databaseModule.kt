package com.apui.pregnancyvitaltracker.di

import com.apui.pregnancyvitaltracker.data.local.VitalDatabase
import com.apui.pregnancyvitaltracker.data.repository.VitalRepositoryImpl
import com.apui.pregnancyvitaltracker.domain.repository.VitalRepository
import com.apui.pregnancyvitaltracker.domain.usecase.VitalDatabaseUseCase
import com.apui.pregnancyvitaltracker.ui.vitalinfo.VitalInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    single { VitalDatabase.getDatabase(get()).itemDao() }
    single<VitalRepository> { VitalRepositoryImpl(get()) }
    single {
        VitalDatabaseUseCase(get())
    }
    viewModel<VitalInfoViewModel> {
        VitalInfoViewModel(get())
    }
}