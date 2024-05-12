package com.example.lego_app.Data

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: Int,
    val iconClicked: Int,
    val badgeCount: Int = 0
)
