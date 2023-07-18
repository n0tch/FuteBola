package com.example.futebola

import android.app.Application
import com.example.futebola.di.applicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

internal class FuteBolaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FuteBolaApplication)
            modules(applicationModules)
        }
    }
}