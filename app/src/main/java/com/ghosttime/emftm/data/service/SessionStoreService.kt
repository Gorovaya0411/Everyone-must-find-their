package com.ghosttime.emftm.data.service

import com.ghosttime.emftm.db.SessionStore
import com.ghosttime.emftm.ui.main_two.InfoForContinue
import javax.inject.Inject

interface SessionStoreService {
    var checkSound: Boolean
    var checkNumCard: Int
    var openListCard: InfoForContinue
    var quantityOpenCard: Int
}

class SessionStoreServiceImpl @Inject constructor(private val sessionStore: SessionStore) :
    SessionStoreService {
    override var checkSound: Boolean
        get() = sessionStore.checkSound
        set(value) {
            sessionStore.checkSound = value
        }
    override var checkNumCard: Int
        get() = sessionStore.checkNumCard
        set(value) {
            sessionStore.checkNumCard = value
        }

    override var quantityOpenCard: Int
        get() = sessionStore.quantityOpenCard
        set(value) {
            sessionStore.quantityOpenCard = value
        }

    override var openListCard: InfoForContinue
        get() = sessionStore.openListCard
        set(value) {
            sessionStore.openListCard = value
        }
}