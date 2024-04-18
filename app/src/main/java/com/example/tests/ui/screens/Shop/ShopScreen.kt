package com.example.tests.ui.screens.Shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tests.R

@Preview(showSystemUi = true, device = "spec:width=1080px,height=2340px,dpi=640")
@Composable
fun ShopScreen() {
    val colors = MaterialTheme.colorScheme
    val brush = Brush.verticalGradient(listOf(colors.background, colors.primary))
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(brush),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height((screenHeight/10).dp))
        }
        item {
            Text(
                text = "Daily Deals",
                fontSize = (screenHeight*0.05).sp,
                fontWeight = FontWeight.Light,
                color = colors.onSecondary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .background(colors.secondary, CircleShape)
                    .fillMaxWidth()
            )
        }

        item {
            Column(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()                .height((screenHeight / 3).dp)
            ) {
                Row(
                    Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    ShowDeal(
                        image = R.drawable.xo_2,
                        price = 2000,
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight
                    )
                    ShowDeal(
                        image = R.drawable.xo_10_1,
                        price = 5000,
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight
                    )
                    ShowUnderLevel(
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight,
                        level = 4
                    )
                }
                Row(
                    Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    ShowUnderLevel(
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight,
                        level = 5
                    )
                    ShowUnderLevel(
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight,
                        level = 7
                    )
                    ShowUnderLevel(
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight,
                        level = 10
                    )
                }
            }
        }

        item {
            Text(
                text = "Coins",
                fontSize = (screenHeight*0.05).sp,
                fontWeight = FontWeight.Light,
                color = colors.onSecondary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .background(colors.secondary, CircleShape)
                    .fillMaxWidth()
            )
        }

        item {
            Column(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .height((screenHeight / 3).dp)
            ) {
                Row(
                    Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    ShowCoins(
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight,
                        coins = 100,
                        price = 0.99
                    )
                    ShowCoins(
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight,
                        coins = 500,
                        price = 4.99
                    )
                    ShowCoins(
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight,
                        coins = 1000,
                        price = 9.99
                    )
                }
                Row(
                    Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    ShowCoins(
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight,
                        coins = 2000,
                        price = 19.99
                    )
                    ShowCoins(
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight,
                        coins = 5000,
                        price = 49.99
                    )
                    ShowCoins(
                        colors = colors,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight,
                        coins = 10000,
                        price = 99.99
                    )
                }
            }
        }
    }
}

@Composable
fun ShowCoins(
    colors: ColorScheme,
    screenWidth: Int,
    screenHeight: Int,
    coins: Int,
    price: Double
) {
    Card(
        shape = RoundedCornerShape(10),
        colors = CardDefaults.cardColors(colors.primary),
        modifier = Modifier
            .padding(5.dp)
            .width((screenWidth / 3 - 15).dp)
            .wrapContentHeight()
    ) {
        Column(
            Modifier
                .wrapContentSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 5.dp),
                colors = CardDefaults.cardColors(colors.onPrimary)
            ) {
                Column(
                    Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = coins.toString(),
                        color = colors.primary,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = screenHeight.sp*0.02,
                    )

                    Image(
                        painter = painterResource(id = R.drawable.coin),
                        contentDescription = null,
                        Modifier
                            .fillMaxSize(0.6f)
                    )
                }
            }

            Text(
                text = "$$price",
                color = colors.onPrimary,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontSize = screenHeight.sp * 0.02,
            )

        }
    }
}

@Composable
fun ShowUnderLevel(colors: ColorScheme, screenWidth: Int, screenHeight: Int, level: Int) {
    Card(
        shape = RoundedCornerShape(10),
        colors = CardDefaults.cardColors(colors.primary),
        modifier = Modifier
            .padding(5.dp)
            .width((screenWidth / 3 - 15).dp)
            .wrapContentHeight()
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Icon(
                imageVector = Icons.Rounded.Lock,
                contentDescription = "lock",
                tint = colors.onPrimary,
                modifier = Modifier
                    .size(((screenWidth / 3 - 30) / 5 * 3).dp)
            )
            Text(
                text = "Unlocks at level $level",
                color = colors.onPrimary,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = screenHeight.sp * 0.015,
            )
        }
    }
}


@Composable
fun ShowDeal(image: Int, price: Int, colors: ColorScheme, screenWidth: Int, screenHeight: Int) {
    Card(
        shape = RoundedCornerShape(10),
        colors = CardDefaults.cardColors(colors.primary),
        modifier = Modifier
            .padding(5.dp)
            .width((screenWidth / 3 - 15).dp)
            .wrapContentHeight()
    ) {
        Column(
            Modifier
                .wrapContentSize()
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(((screenWidth / 3 - 30) / 5 * 3).dp)
            )

            Text(
                text = price.toString(),
                color = colors.onPrimary,
                textAlign = TextAlign.Right,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
                fontSize = screenHeight.sp*0.025,
            )
            Image(
                painter = painterResource(id = R.drawable.coin),
                contentDescription = null,
                Modifier
                    .fillMaxSize(0.6f)
                    .weight(1f)
            )
        }
    }
}