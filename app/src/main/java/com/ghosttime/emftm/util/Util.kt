package com.ghosttime.emftm.util

import androidx.annotation.StringRes
import com.ghosttime.emftm.R

enum class JSEvent(
    @StringRes val eventTextId: Int
) {
    INJECT_WITH_REG(
        eventTextId = R.string.logs_js_with_reg
    ),
    WEB_ROUTE(
        eventTextId = R.string.logs_web_route
    ),
    SERVICE_ROUTE(
        eventTextId = R.string.logs_service_route
    ),
    FAIL_URI_PARSE(
        eventTextId = R.string.logs_fail_uri_parse
    ),
    DEPOSIT(
        eventTextId = R.string.logs_deposit
    ),
    REGISTER(
        eventTextId = R.string.logs_register
    )
}
