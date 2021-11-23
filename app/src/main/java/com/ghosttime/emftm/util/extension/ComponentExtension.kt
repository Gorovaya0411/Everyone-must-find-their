package com.ghosttime.emftm.util.extension

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity

inline fun AppCompatActivity.processDeeplinks(
    crossinline onHandleAppLink: (appLink: Uri?) -> Unit
) {
}