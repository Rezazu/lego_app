package com.example.lego_app.Data

import androidx.annotation.DrawableRes

data class News(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)
