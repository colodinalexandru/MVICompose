package com.colodin.mvicompose

import android.annotation.SuppressLint
import android.app.Application
import timber.log.Timber

@SuppressLint("Registered")
class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // don't start koin
        Timber.plant(Timber.DebugTree())
    }
}