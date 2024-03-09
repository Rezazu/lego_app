package com.example.lego_app

import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.lego_app.Data.News
import com.example.lego_app.Data.Theme
import com.example.lego_app.Data.User
import com.example.lego_app.ui.theme.BrightYellow
import com.example.lego_app.ui.theme.TextWhite

@Composable
fun Home() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(
            modifier = Modifier
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
        contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
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