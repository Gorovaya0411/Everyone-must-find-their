package com.ghosttime.emftm.ui.main

import com.ghosttime.emftm.ui.main_two.InfoForContinue
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MainActivityView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun goToMenuFragment()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun goToOptionFragment()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun goToSecondaryMenuFragment()
}

abstract class MainActivityPresenter : MvpPresenter<MainActivityView>() {
    abstract fun getCheckSound(): Boolean
    abstract fun setCheckSound(sound: Boolean)
    abstract fun getNumCard(): Int
    abstract fun setNumCard(numCard: Int)
    abstract fun getOpenListCard(): InfoForContinue
    abstract fun setOpenListCard(listCard: InfoForContinue)
    abstract fun getQuantityOpenCard(): Int
    abstract fun setQuantityOpenCard(quantityOpenCard: Int)
}