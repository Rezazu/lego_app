package com.example.lego_app

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lego_app.Data.*
import com.example.lego_app.Navigation.Screen
import com.example.lego_app.Screen.ProfileScreen.*
import com.example.lego_app.ui.theme.*
import java.math.BigDecimal

@Composable
fun ProfileScreen(navController: NavController) {
    var dynamicComposable by remember { mutableStateOf<@Composable ColumnScope.() -> Unit> (@Composable { accountOverviewScreen() })}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnyComposable {
            dynamicComposable()
        }
        ProfileButton(
            items = listOf(
                ProfileButtonItem(
                    name = "Overview Akun",
                    menu = accountOverviewScreen,
                    icon = R.drawable.ic_legohead2
                ),
                ProfileButtonItem(
                    name = "Pesanan Saya",
                    menu = orderScreen,
                    icon = R.drawable.ic_shipping
                ),
                ProfileButtonItem(
                    name = "Data Diri & Alamat",
                    menu = dataAdressScreen,
                    icon = R.drawable.ic_address
                ),
                ProfileButtonItem(
                    name = "Wishlist",
                    menu = wishlistScreen,
                    icon = R.drawable.ic_heart
                ),
                ProfileButtonItem(
                    name = "Pengaturan Akun",
                    menu = accountSettingScreen,
                    icon = R.drawable.ic_setting
                ),
                ProfileButtonItem(
                    name = "Keluar",
                    menu = logoutScreen,
                    icon = R.drawable.ic_logout
                )
            ),
            dynamicComposable,
            onClickItem = {
                dynamicComposable = it.menu
            }
        )
        BantuanSection(
            bantuanItem = listOf(
                ProfileBantuanItem(
                    "Pengantaran & Kurir",
                    "home"
                ),
                ProfileBantuanItem(
                    "FAQs",
                    "home"
                ),
                ProfileBantuanItem(
                    "Penggantian Part & Buku Instruksi",
                    "home"
                ),
                ProfileBantuanItem(
                    "Kontak",
                    "home"
                ),
            )
        )
        Spacer(modifier = Modifier
            .height(100.dp)
        )
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun ProfileButton(
    items: List<ProfileButtonItem>,
    currentCompose : @Composable() (ColumnScope.() -> Unit),
    onClickItem: (ProfileButtonItem) -> Unit,
) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items.forEach { item->
                val selected = currentCompose.toString() == item.menu.toString()
                ProfileButtonItem(
                    item = item,
                    selected = selected,
                    onClick = { onClickItem(item) },
                )
            }
            Divider(
                color = BorderGray,
                thickness = 0.8.dp,
            )
        }

}

@Composable
fun ProfileButtonItem(
    item: ProfileButtonItem,
    selected: Boolean,
    onClick: (ProfileButtonItem) -> Unit,
) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(if (selected) DarkBlue else Color.White)
                .clickable { onClick(item) }
        ) {
            Divider(
                color = BorderGray,
                thickness = 0.8.dp,
            )
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 10.dp)

            ) {
                Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = "Item Icon",
                    tint = if (selected) Color.White else Color.Black,
                    modifier = Modifier
                        .size(18.dp)

                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = item.name,
                    fontSize = 12.sp,
                    color = if (selected) Color.White else Color.Black,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
}

@Composable
fun BantuanSection(
    bantuanItem : List<ProfileBantuanItem>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "Bantuan",
            fontSize = 12.sp,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
            modifier = Modifier
                .padding(15.dp)
        )
        Divider(
            color = BorderGray,
            thickness = 0.8.dp,
        )
        bantuanItem.forEach { item->
            Text(
                text = item.name,
                fontSize = 10.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .clickable { /*TODO*/ }
            )
            Divider(
                color = BorderGray,
                thickness = 0.8.dp,
            )
        }
    }
}

@Composable
fun AnyComposable(
    anyComposable: @Composable () -> Unit
) {
    anyComposable()
}

val composable2 : @Composable ColumnScope.() -> Unit = @Composable {
    Box(
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .size(80.dp)
            .background(Color.Blue)
    )
}

// small green rectangle at end of column
val composable3 : @Composable ColumnScope.() -> Unit = @Composable {
    Box(
        modifier = Modifier
            .align(Alignment.End)
            .size(width = 100.dp, height = 30.dp)
            .background(Color.Green)
    )
}