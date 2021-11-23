package com.ghosttime.emftm.di.modul.ui.main

import com.ghosttime.emftm.ui.main.MainActivityPresenter
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
@MainActivityScope
interface MainActivitySubcomponent {
    val presenter: MainActivityPresenter
}