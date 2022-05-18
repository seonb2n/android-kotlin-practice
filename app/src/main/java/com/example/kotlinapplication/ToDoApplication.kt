package com.example.kotlinapplication

import android.app.Application
import com.example.kotlinapplication.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.logging.Level

class ToDoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        //TODO Koin Trigger
        startKoin {
            androidLogger(org.koin.core.logger.Level.ERROR)
            androidContext(this@ToDoApplication)
            modules(appModule)
        }
    }
}