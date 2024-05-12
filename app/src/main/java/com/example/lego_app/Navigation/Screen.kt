package com.example.lego_app.Navigation

sealed class Screen (val route: String) {
    object Home : Screen("home")
    object News : Screen("news")
    object Collection : Screen("collection")
    object Profile : Screen("profile_overview")

    object AccountOverview : Screen("account_overview")
    object Order : Screen("order")

}