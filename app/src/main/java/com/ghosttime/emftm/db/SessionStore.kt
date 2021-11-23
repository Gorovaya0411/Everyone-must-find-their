package com.ghosttime.emftm.db

import android.content.SharedPreferences
import com.ghosttime.emftm.ui.main_two.InfoForContinue
import com.google.gson.Gson

class SessionStore(private val sharedPreferences: SharedPreferences) {

    var checkSound: Boolean
        get() = sharedPreferences.getBoolean(KEY_CHECK_SOUND, true)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_CHECK_SOUND, value).apply()
        }
    var checkNumCard: Int
        get() = sharedPreferences.getInt(KEY_CHECK_NUM_CARD, 6)
        set(value) {
            sharedPreferences.edit().putInt(KEY_CHECK_NUM_CARD, value).apply()
        }
    var openListCard: InfoForContinue
        get() {
            return try {
                Gson().fromJson(
                    sharedPreferences.getString(KEY_OPEN_LIST_CARD, "") ?: "",
                    InfoForContinue::class.java
                )
            } catch (e: Exception) {
                InfoForContinue(ArrayList())
            }
        }
        set(value) {
            sharedPreferences.edit().putString(KEY_OPEN_LIST_CARD, Gson().toJson(value)).apply()
        }
    var quantityOpenCard: Int
        get() = sharedPreferences.getInt(KEY_QUANTITY_OPEN_CARD, 0)
        set(value) {
            sharedPreferences.edit().putInt(KEY_QUANTITY_OPEN_CARD, value).apply()
        }

    companion object {
        const val KEY_CHECK_SOUND = "check_shake"
        const val KEY_QUANTITY_OPEN_CARD = "key_quantity_open_card"
        const val KEY_CHECK_NUM_CARD = "quantity"
        const val KEY_OPEN_LIST_CARD = "open_list_card"
    }
}
