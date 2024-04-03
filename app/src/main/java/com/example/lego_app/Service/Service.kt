package com.example.lego_app.Service

import java.math.BigDecimal
import java.text.DecimalFormat

object Service {
    fun DecimalPrice(bigDecimal: BigDecimal): String {
        val dec = DecimalFormat("#,###")
        return "Rp. " + dec.format(bigDecimal)
    }
}