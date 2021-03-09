package com.example.assginmentbet

import android.app.Application
import com.example.assginmentbet.di.NetworkModule
import com.example.assginmentbet.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(listOf(
                ViewModelModule,
                NetworkModule
            ))
        }
    }
}