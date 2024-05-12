package com.example.lego_app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NewsScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        Text(
            text = backStackEntry.value?.destination?.route.toString(),
            color = Color.Black,
            fontSize = 20.sp
        )
    }
}