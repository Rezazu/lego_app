package com.example.lego_app.Service

import androidx.compose.ui.graphics.Color
import com.example.lego_app.ui.theme.LightGreen
import java.math.BigDecimal
import java.text.DecimalFormat

object Service {
    fun DecimalPrice(bigDecimal: BigDecimal): String {
        val dec = DecimalFormat("#,###")
        return "Rp. " + dec.format(bigDecimal)
    }

    fun StatusColor(status: String): Color {
        var color : Color = Color.Black
        if (status == "Diterima") {
            color = LightGreen
        }
        return color
    }
}