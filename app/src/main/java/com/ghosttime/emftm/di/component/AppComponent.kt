package com.ghosttime.emftm.di.component


import com.ghosttime.emftm.di.modul.app.AppModule
import com.ghosttime.emftm.di.modul.app.AppScope
import com.ghosttime.emftm.di.modul.ui.main.MainActivityModule
import com.ghosttime.emftm.di.modul.ui.main.MainActivitySubcomponent

import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun with(mainActivityModule: MainActivityModule): MainActivitySubcomponent
}