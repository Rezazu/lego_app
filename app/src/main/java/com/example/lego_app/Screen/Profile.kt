package com.example.lego_app

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lego_app.Data.Order
import com.example.lego_app.Data.Product
import com.example.lego_app.Data.ProfileButtonItem
import com.example.lego_app.Data.User
import com.example.lego_app.Service.Service
import com.example.lego_app.ui.theme.*
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.math.BigDecimal

@Composable
fun Profile(){

    val navController = rememberNavController()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            AccountOverview(
                user = User(
                    "Rezky Donny Putranto",
                    960
                )
            )
            OrderSection(
                listOf(
                    Order(
                        1,
                        111222444,
                        "05-05-2024",
                        listOf(
                            Product(
                                "LEGO AT-TE™ Walker 75337",
                                "Star Wars",
                                BigDecimal(2400000),
                                R.drawable.img_item1
                            ),
                            Product(
                                "LEGO 21348 Dungeons & Dragons",
                                "Ideas",
                                BigDecimal(3000000),
                                R.drawable.img_item3
                            )
                        ),
                        "Regular",
                        "Diterima"
                    ),
                    Order(
                        2,
                        111222555,
                        "01-12-2024",
                        listOf(
                            Product(
                                "LEGO AT-TE™ Walker 75337",
                                "Star Wars",
                                BigDecimal(2400000),
                                R.drawable.img_item1
                            ),
                            Product(
                                "LEGO 21348 Dungeons & Dragons",
                                "Ideas",
                                BigDecimal(3000000),
                                R.drawable.img_item3
                            )
                        ),
                        "Regular",
                        "Diterima"
                    )
                )
            )
            ProfileButton(
                items = listOf(
                    ProfileButtonItem(
                        name = "Overview Akun",
                        route = "home",
                        icon = R.drawable.ic_legohead2
                    ),
                    ProfileButtonItem(
                        name = "Pesanan Saya",
                        route = "home",
                        icon = R.drawable.ic_shipping
                    ),
                    ProfileButtonItem(
                        name = "Data Diri & Alamat",
                        route = "home",
                        icon = R.drawable.ic_address
                    ),
                    ProfileButtonItem(
                        name = "Wishlist",
                        route = "home",
                        icon = R.drawable.ic_heart
                    ),
                    ProfileButtonItem(
                        name = "Pengaturan Akun",
                        route = "home",
                        icon = R.drawable.ic_setting
                    ),
                    ProfileButtonItem(
                        name = "Keluar",
                        route = "home",
                        icon = R.drawable.ic_logout
                    )
                ),
                navController = navController
            )
            Spacer(modifier = Modifier.height(90.dp))
        }
    }
}

@Composable
fun AccountOverview(
    user: User
) {
    Column(

    ) {
        Text(
            text = "Akun saya",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp),
            fontFamily = FontFamily(Font(R.font.montserrat_semibold))
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(380.dp)
                    .height(120.dp)
                    .background(LightGrayBackground)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_insider),
                        contentDescription = "Insider Icon",
                        modifier = Modifier
                            .width(90.dp)
                            .height(113.dp)
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 5.dp),

                        )
                    Text(
                        text = "Hey, LEGO® Insider! (That's\n" + "you!)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 10.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_insider2),
                        contentDescription = "Insider Icon",
                        modifier = Modifier
                            .height(31.dp)
                            .width(103.dp)
                            .align(Alignment.Bottom)
                            .offset(x = -20.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight()
                        .background(BrightYellow),

                    ) {
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
                                append("Hi,\n")
                            }
                            withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold)) {
                                append(user.name)
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(DarkRed)
                ) {
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal, color = Color.White)) {
                                append("LEGO® Insiders Points\n")
                            }
                            withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color.White)) {
                                append(user.point.toString())
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(105.dp)
                    .background(DarkBlue)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Your LEGO® Insiders card number: 12345678",
                        fontSize = 12.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                        modifier = Modifier
                            .align(alignment = CenterHorizontally)
                            .padding(bottom = 10.dp)

                    )
                    Button(
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                        modifier = Modifier
                            .width(168.dp)
                            .height(28.dp)
                            .align(alignment = CenterHorizontally),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Explore LEGO® Insiders",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.montserrat_semibold))
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun OrderSection(
    listOrder: List <Order>
) {
    Column(
        modifier = Modifier,

    ) {
        Text(
            text = "Pesanan Saya",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp),
            fontFamily = FontFamily(Font(R.font.montserrat_semibold))
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .defaultMinSize(minHeight = 250.dp)
                .background(BackgroundWhite)
                .clip(RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center,
        ) {
            if (listOrder.isNotEmpty()) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(10.dp)
                ) {
                    (1 .. listOrder.size).forEach {
                        OrderItem(order = listOrder[it-1], product = listOrder[it-1].product[0])
                    }
                }
            } else {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(10.dp)

                ) {
                    Text(
                        text = "Tidak Memiliki Pesanan Aktif",
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.montserrat_medium))
                    )
                    Button(
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = DarkBlue),
                        modifier = Modifier
                            .width(110.dp)
                            .height(32.dp)
                            .align(alignment = CenterHorizontally),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Mulai Belanja",
                            fontSize = 9.sp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun OrderItem(
    order: Order,
    product: Product,
) {
    Card(
        modifier = Modifier
            .width(360.dp)
            .height(110.dp)
            .padding(vertical = 5.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(1.dp, BorderGray, shape = RoundedCornerShape(15.dp)),
        elevation = 10.dp
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp, end = 5.dp, start = 5.dp)
                ) {
                    Column (modifier = Modifier.padding(bottom = 2.dp)){
                        Text(
                            text = order.order_number.toString(),
                            fontSize = 8.sp,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.montserrat_medium))
                        )
                        Text(
                            text = order.date_created,
                            fontSize = 6.sp,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.montserrat_regular))
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = order.status,
                        fontSize = 8.sp,
                        color = Service.StatusColor(order.status),
                        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp, vertical = 5.dp)
                ) {
                    Image(
                        painter = painterResource(id = product.image),
                        contentDescription =  "Order Image",
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .border(1.dp, BorderGray, shape = RoundedCornerShape(10.dp)),
                    )
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                    ) {
                        Text(
                            text = if (order.product.size > 1) product.name + " (+${order.product.size-1})" else product.name,
                            fontSize = 10.sp,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                        )
                        Text(
                            text = Service.DecimalPrice(product.price),
                            fontSize = 8.sp,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                        )
                        Row(

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_shipping),
                                contentDescription = "Shipping",
                                tint = Color.DarkGray,
                                modifier = Modifier
                                    .size(10.dp)
                                    .padding(end = 2.dp)
                            )
                            Text(
                                text = order.shipping,
                                fontSize = 8.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                            )
                        }
                    }
                    Spacer(Modifier.weight(1f))
                    TextButton(
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = DarkBlue),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .width(58.dp)
                            .height(22.dp)
                            .align(Alignment.Bottom),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Detail",
                            fontSize = 8.sp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileButton(
    items: List<ProfileButtonItem>,
    navController: NavController
) {
    var selected by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items.forEach { item->
                ProfileButtonItem(item = item)
            }
            Divider(
                color = BorderGray,
                thickness = 0.8.dp,
            )
        }

}

@Composable
fun ProfileButtonItem(
    item: ProfileButtonItem
) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clickable { /*TODO*/ }
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
                    modifier = Modifier
                        .size(18.dp)

                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = item.name,
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
}

@Composable
fun BantuanSection(

) {

}