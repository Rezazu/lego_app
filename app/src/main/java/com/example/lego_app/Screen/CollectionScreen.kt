package com.example.lego_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lego_app.Screen.ProfileScreen.accountOverviewScreen
import com.example.lego_app.Screen.ProfileScreen.orderScreen

@Composable
fun CollectionScreen(navController: NavController){
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