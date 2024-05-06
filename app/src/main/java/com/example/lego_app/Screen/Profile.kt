package com.example.lego_app

import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lego_app.Data.User
import com.example.lego_app.ui.theme.*
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Profile(){
    AccountOverview(
        user = User(
            "Rezky Donny Putranto",
            960
        )
    )
}

@Composable
fun AccountOverview(
    user: User
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
    ) {
        Box(
            modifier = Modifier
                .width(360.dp)
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