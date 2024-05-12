package com.example.lego_app.Screen.ProfileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val wishlistScreen : @Composable ColumnScope.() -> Unit = @Composable {
    Box(modifier = Modifier
        .height(200.dp)
        .background(Color.White)
    ) {
        Text(text = "Wishlist_Screen")
    }
}