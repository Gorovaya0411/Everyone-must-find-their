package com.ghosttime.emftm.di.modul.ui.main

import com.ghosttime.emftm.domain.MainUseCase
import com.ghosttime.emftm.ui.main.MainActivityPresenter
import com.ghosttime.emftm.ui.main.MainActivityPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @MainActivityScope
    fun provideMainActivityPresenter(mainUseCase: MainUseCase): MainActivityPresenter {
        return MainActivityPresenterImpl(mainUseCase)
    }
}