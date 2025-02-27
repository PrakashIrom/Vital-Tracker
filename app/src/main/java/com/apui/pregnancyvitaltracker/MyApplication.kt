package com.apui.pregnancyvitaltracker

import android.app.Application
import com.apui.pregnancyvitaltracker.di.databaseModule
import com.apui.pregnancyvitaltracker.di.reminderModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(databaseModule, reminderModule)
        }
    }
}