package com.example.lego_app.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lego_app.*
import com.example.lego_app.Screen.ProfileScreen.*

@Composable
fun Navigation(navController: NavController) {
    NavHost(navController = navController as NavHostController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.News.route) {
            NewsScreen(navController)
        }
        composable(Screen.Collection.route) {
            CollectionScreen(navController)
        }
        navigation(
            startDestination = Screen.Profile.route,
            route = "profile"
        ) {
            composable(Screen.Profile.route) {
                ProfileScreen(navController)
            }
//            composable(Screen.AccountOverview.route) {
//                AnyComposable {
//                    accountOverviewScreen
//                }
//
//            }
//            composable(Screen.Order.route) {
//                AnyComposable {
//                    orderScreen
//                }
//            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route?:return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}

//state