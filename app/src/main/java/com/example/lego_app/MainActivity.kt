package com.example.lego_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lego_app.Data.BottomNavItem
import com.example.lego_app.ui.theme.BrightYellow
import com.example.lego_app.ui.theme.DarkGray
import com.example.lego_app.ui.theme.Lego_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lego_appTheme {
                Home()
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Home",
                                    route = "home",
                                    icon = R.drawable.ic_home,
                                    iconClicked = R.drawable.ic_home_selected
                                ),
                                BottomNavItem(
                                    name = "News",
                                    route = "news",
                                    icon = R.drawable.ic_news,
                                    iconClicked = R.drawable.ic_news_selected
                                ),
                                BottomNavItem(
                                    name = "Collection",
                                    route = "collection",
                                    icon = R.drawable.ic_brick,
                                    iconClicked = R.drawable.ic_legobrick_selected
                                ),
                                BottomNavItem(
                                    name = "Profile",
                                    route = "profile",
                                    icon = R.drawable.ic_legohead2,
                                    iconClicked = R.drawable.ic_legohead_selected
                                )

                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lego_appTheme {
        Greeting("Android")
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Home()
        }
        composable("news") {
            News()
        }
        composable("collection") {
            Collection()
        }
        composable("profile") {
            Profile()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier
            .height(80.dp)
            .drawBehind {
                drawLine( //top line
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = size.width, y = 0f),
                    strokeWidth = 3f,
                    color = BrightYellow
                )
            },
        backgroundColor = Color.White,
        elevation = 5.dp,

        ) {

        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                icon =  {
                    Column(
                        modifier = modifier
                            .height(50.dp)
                            .width(38.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (item.badgeCount>0) {
                            BadgedBox(
                                badge = {
                                    Text(text = item.badgeCount.toString())
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = if (selected) item.iconClicked else item.icon),
                                    contentDescription = item.name,
                                    tint = Color.Unspecified
                                )
                            }
                        } else {
                            Icon(
                                painter = painterResource(id = if (selected) item.iconClicked else item.icon),
                                contentDescription = item.name,
                                tint = Color.Unspecified
                            )
                        }
                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp,
                                color = DarkGray
                            )
                        }
                    }
                }
            )
        }
    }
}