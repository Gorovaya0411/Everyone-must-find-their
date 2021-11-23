package com.ghosttime.emftm.di.modul.app

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.preference.PreferenceManager
import com.ghosttime.emftm.data.service.SessionStoreService
import com.ghosttime.emftm.data.service.SessionStoreServiceImpl
import com.ghosttime.emftm.db.SessionStore
import com.ghosttime.emftm.MyApplication
import com.ghosttime.emftm.domain.MainUseCase
import com.ghosttime.emftm.domain.MainUseCaseImpl
import dagger.Module
import dagger.Provides

@Module()
class AppModule(private val myApplication: MyApplication) {

    @Provides
    @AppScope
    @AppContext
    fun provideAppContext(): Context = myApplication.applicationContext

    @Provides
    @AppScope
    fun provideSessionStoreService(sharedPreferences: SharedPreferences): SessionStoreService {
        return SessionStoreServiceImpl(SessionStore(sharedPreferences))
    }

    @Provides
    @AppScope
    fun provideConnectivityManager(@AppContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @AppScope
    fun provideDefaultSharedPreferences(@AppContext context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @AppScope
    fun provideMainUseCase(
        sessionStoreService: SessionStoreService
    ): MainUseCase {
        return MainUseCaseImpl(sessionStoreService)
    }
}