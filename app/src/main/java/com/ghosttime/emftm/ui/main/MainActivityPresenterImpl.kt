package com.ghosttime.emftm.ui.main

import com.ghosttime.emftm.domain.MainUseCase
import com.ghosttime.emftm.ui.main_two.InfoForContinue
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MainActivityPresenterImpl @Inject constructor(
    private val mainUseCase: MainUseCase

) : MainActivityPresenter() {

    override fun getCheckSound(): Boolean {
        return mainUseCase.checkSound
    }

    override fun setCheckSound(sound: Boolean) {
        mainUseCase.checkSound = sound
    }

    override fun getOpenListCard(): InfoForContinue {
        return mainUseCase.openListCard
    }

    override fun setOpenListCard(listCard: InfoForContinue) {
        mainUseCase.openListCard = listCard
    }

    override fun getNumCard(): Int {
        return mainUseCase.checkNumCard
    }

    override fun setNumCard(numCard: Int) {
        mainUseCase.checkNumCard = numCard
    }

    override fun getQuantityOpenCard(): Int {
        return mainUseCase.quantityOpenCard
    }

    override fun setQuantityOpenCard(quantityOpenCard: Int) {
        mainUseCase.quantityOpenCard = quantityOpenCard
    }
}