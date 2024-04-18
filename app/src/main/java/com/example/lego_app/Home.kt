package com.example.lego_app

import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lego_app.Data.*
import com.example.lego_app.Data.News
import com.example.lego_app.Service.Service
import com.example.lego_app.ui.theme.*
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.math.BigDecimal

@Composable
fun Home() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            HeaderSection(
                modifier = Modifier,
                User(
                    "Rezky Donny Putranto",
                    960
                )
            )
            NewSection(
                listOf(
                    News(
                        "Celebrate 20 years of Clone Wars adventures",
                    "Let your mind drift to a galaxy far, far away as you build and display a massive Ultimate Collector Series version of the Venator-Class Republic Attack Cruiser.",
                    R.drawable.img_news1
                    ),
                    News(
                        "Celebrate 20 years of Clone Wars adventures",
                        "Let your mind drift to a galaxy far, far away as you build and display a massive Ultimate Collector Series version of the Venator-Class Republic Attack Cruiser.",
                        R.drawable.img_news2
                    ),
                    News(
                        "Celebrate 20 years of Clone Wars adventures",
                        "Let your mind drift to a galaxy far, far away as you build and display a massive Ultimate Collector Series version of the Venator-Class Republic Attack Cruiser.",
                        R.drawable.img_news3
                    )
                )
            )
            ThemeSection(
                listOf(
                    Theme(
                        "Star Wars",
                        R.drawable.ic_starwars
                    ),
                    Theme(
                        "Ninjago",
                        R.drawable.ic_ninjago
                    ),
                    Theme(
                        "City",
                        R.drawable.ic_city
                    ),
                    Theme(
                        "Technic",
                        R.drawable.ic_technic
                    ),
                    Theme(
                        "Ideas",
                        R.drawable.ic_ideas
                    )
                )
            )

            NewsBanner(newsImage = R.drawable.img_new, modifier = Modifier)

            NewProductSection(
                listOf(
                    Product(
                        "LEGO AT-TE™ Walker 75337",
                        "Star Wars",
                        BigDecimal(2400000),
                        R.drawable.img_item1
                    ),
                    Product(
                        "LEGO Penguin Slushy Van 60384",
                        "City",
                        BigDecimal(359000),
                        R.drawable.img_item2
                    ),
                    Product(
                        "LEGO 21348 Dungeons & Dragons",
                        "Ideas",
                        BigDecimal(3000000),
                        R.drawable.img_item3
                    )
                )
            )

            NewsBanner(newsImage = R.drawable.img_sale, modifier = Modifier)

            SaleProductSection(
                 listOf(
                     Product(
                         "LEGO Heatwave Lava Dragon 71793",
                         "Ninjago",
                         BigDecimal(999000),
                         R.drawable.img_item4
                     ),
                     Product(
                         "LEGO Technic Heavy Duty Bulldozer 42163",
                         "Technic",
                         BigDecimal(139000),
                         R.drawable.img_item5
                     ),
                     Product(
                         "LEGO Ahsoka Tano's T-6 Jedi Shuttle 75362",
                         "Star Wars",
                         BigDecimal(3000000),
                         R.drawable.img_item6
                     )
                 )
            )
            
            NewsBannerStore(
                newsText = "Telah Dibuka!\n" +
                    "LEGO® Bintaro Jaya Xchange Mall 2 – Ground Floor",
                newsImage = R.drawable.img_legostore,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
    user: User
) {
    BoxWithConstraints(modifier = modifier
        .fillMaxWidth()
        .background(BrightYellow)
        .height(160.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "More",
                tint = Color.DarkGray,
                modifier = modifier
                    .size(20.dp)
                    .clickable { }
            )
            Image(
                painter = painterResource(id = R.drawable.ic_lego),
                contentDescription = "Lego",
                modifier = modifier
                    .size(30.dp)
                    .offset(15.dp, -5.dp)
            )
            Spacer(
                modifier = modifier
                    .width(240.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint= Color.Unspecified,
                modifier = modifier.size(30.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notification",
                tint= Color.Unspecified,
                modifier = modifier
                    .size(30.dp)
                    .offset(10.dp, 0.dp)
            )
        }
        Spacer(modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .height(40.dp)
        )
        Box(
            modifier = modifier
                .shadow(elevation = 12.dp, shape = RoundedCornerShape(16.dp))
                .padding(bottom = 0.dp)
                .width(340.dp)
                .height(90.dp)
                .align(Alignment.BottomCenter)
                .background(Color.White)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_legohead),
                        contentDescription = "lego Head",
                        tint= Color.Unspecified,
                        modifier = modifier
                            .size(32.dp)
                    )
                    Spacer(modifier = modifier.width(5.dp))
                    Column(
                    ) {
                        Text(
                            text = "Welcome!",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = user.name,
                            fontSize = 10.sp
                        )
                    }
                }

                Icon(
                    painter = painterResource(id = R.drawable.ic_line1),
                    contentDescription = "lego Head",
                    tint= Color.Unspecified,
                    modifier = modifier
                        .size(32.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .offset(x = -10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_insider),
                        contentDescription = "lego insider",
                        tint= Color.Unspecified,
                        modifier = modifier
                            .size(32.dp)
                    )
                    Spacer(modifier = modifier.width(5.dp))
                    Column(

                    ) {
                        Text(
                            text = "Lego Insider",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "${user.point} Points",
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SearchBar() {

}

@Composable
fun NewSection(
    news: List<News>
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(news.size) {
            NewsItem(news[it])
        }
    }
}


@Composable
fun NewsItem(
    news: News
) {
    Card(
        modifier = Modifier
            .width(350.dp)
            .height(200.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = news.image),
                contentDescription = "News",
                contentScale = ContentScale.Crop,
                modifier = Modifier
            )
            Box(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.6f))
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 5.dp, horizontal = 15.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.85f)
                        .padding(bottom = 10.dp)
                ) {
                    Text(
                        text = news.title,
                        color = TextWhite,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = news.description,
                        color = TextWhite,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun ThemeSection(
    theme: List<Theme>
) {
    Text(
        text = "LEGO Theme",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(15.dp)
    )
    LazyRow(
        contentPadding = PaddingValues(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(theme.size) {
            ThemeItem(theme[it])
        }
    }
}

@Composable
fun ThemeItem(
    theme: Theme
) {
    Card(
        modifier = Modifier
            .width(110.dp)
            .height(55.dp)
            .border(1.dp, BrightYellow, shape = RoundedCornerShape(15.dp)),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = theme.image),
                contentDescription = "News",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(64.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun NewsBanner(
    newsImage : Int,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .height(200.dp)
    ) {
        Image(painter = painterResource(id = newsImage)
            , contentDescription = "News Banner",
            modifier = Modifier.fillMaxSize()

        )
    }
}

@Composable
fun NewProductSection(
    product: List<Product>
) {
    Text(
        text = "New Products",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(12.dp)
    )
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(product.size) {
            ProductItem(product[it])
        }
    }
}

@Composable
fun SaleProductSection(
    product: List<Product>
) {
    Text(
        text = "ON SALE",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(12.dp)
    )
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(product.size) {
            ProductItem(product[it])
        }
    }
}

@Composable
fun ProductItem(
    product: Product
) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(225.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = "Item",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(130.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column {
                    Text(
                        text = product.theme,
                        fontSize = 8.sp,
                        color = PaleBlue,
                    )
                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )
                    Text(
                        text = product.name,
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )
                    Text(
                        text = Service.DecimalPrice(product.price),
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun NewsBannerStore(
    newsText : String,
    newsImage : Int,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(BackgroundWhite)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
                    .padding(vertical = 16.dp, horizontal = 10.dp)
            ) {
                Text(
                    text = newsText,
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(
                    modifier = modifier
                        .height(40.dp)
                )
                Text(
                    text = "Lihat semua LEGO Store",
                    fontSize = 10.sp,
                    color = BrightOrange,
                    fontWeight = FontWeight.SemiBold,
                )
            }
            Image(
                painter = painterResource(id = newsImage),
                contentDescription = "News Store",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .width(200.dp)
            )
        }
    }
}

