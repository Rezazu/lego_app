package com.example.lego_app.Data

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable

data class ProfileButtonItem(
    val name: String,
    val menu: @Composable() (ColumnScope.() -> Unit),
    val icon: Int,
)
