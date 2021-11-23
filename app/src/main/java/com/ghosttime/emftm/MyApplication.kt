package com.ghosttime.emftm

import android.app.Application
import com.ghosttime.emftm.di.component.AppComponent
import com.ghosttime.emftm.di.component.DaggerAppComponent
import com.ghosttime.emftm.di.modul.app.AppModule


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var appComponent: AppComponent
            private set
    }
}