package com.ghosttime.emftm.ui.main

import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ghosttime.emftm.R
import com.ghosttime.emftm.MyApplication
import com.ghosttime.emftm.di.modul.ui.main.MainActivityModule
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class MainActivity : MvpAppCompatActivity(), MainActivityView {

    @InjectPresenter
    lateinit var presenter: MainActivityPresenter

    @ProvidePresenter
    fun provideMainActivityPresenter(): MainActivityPresenter {
        return MyApplication.appComponent.with(MainActivityModule()).presenter
    }

    private lateinit var navController: NavController
    private val player: MediaPlayer by lazy(LazyThreadSafetyMode.NONE) {
        MediaPlayer.create(this, R.raw.sound)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

    private fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let {
                it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_nav_host_container) as NavHostFragment
        navController = navHostFragment.navController
        goToMenuFragment()
    }

    override fun goToMenuFragment() {
        navController.navigate(R.id.action_splashFragment_to_menuFragment)
    }

    override fun goToOptionFragment() {
        navController.navigate(R.id.action_menuFragment_to_optionFragment)
    }

    override fun goToSecondaryMenuFragment() {
        navController.navigate(R.id.action_menuFragment_to_secondaryMenuFragment)
    }

    fun startSound() {
        player.start()
    }
}
