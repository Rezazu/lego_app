package com.example.lego_app.Data

import androidx.annotation.DrawableRes
import java.math.BigDecimal

data class Product(
    val name: String,
    val theme: String,
    val price: BigDecimal,
    @DrawableRes val image: Int

)
