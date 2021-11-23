package com.ghosttime.emftm.domain

import com.ghosttime.emftm.data.service.SessionStoreService
import com.ghosttime.emftm.ui.main_two.InfoForContinue
import javax.inject.Inject

interface MainUseCase {
    var checkSound: Boolean
    var checkNumCard: Int
    var openListCard: InfoForContinue
    var quantityOpenCard: Int
}

class MainUseCaseImpl @Inject constructor(
    private val sessionStoreService: SessionStoreService
) : MainUseCase {

    override var checkSound: Boolean
        get() = sessionStoreService.checkSound
        set(value) {
            sessionStoreService.checkSound = value
        }


    override var checkNumCard: Int
        get() = sessionStoreService.checkNumCard
        set(value) {
            sessionStoreService.checkNumCard = value
        }

    override var quantityOpenCard: Int
        get() = sessionStoreService.quantityOpenCard
        set(value) {
            sessionStoreService.quantityOpenCard = value
        }

    override var openListCard: InfoForContinue
        get() = sessionStoreService.openListCard
        set(value) {
            sessionStoreService.openListCard = value
        }
}