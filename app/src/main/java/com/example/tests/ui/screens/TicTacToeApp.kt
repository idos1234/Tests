package com.example.tests.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.colorspace.ColorSpace
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tests.R
import com.example.tests.ui.screens.Game.CreateOrJoinGame
import com.example.tests.ui.screens.Game.GameScreen
import com.example.tests.ui.screens.Game.SearchGame
import com.example.tests.ui.screens.Menu.CustomLinearProgressIndicator
import com.example.tests.ui.screens.Menu.HomeScreen
import com.example.tests.ui.screens.Menu.LeadBoardScreen
import com.example.tests.ui.screens.Menu.ProfileScreen
import com.example.tests.ui.screens.Shop.ShopScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TicTacToeApp() {
    val navController = rememberNavController()
    val colors = MaterialTheme.colorScheme

    var leadBoardColor by remember {
        mutableStateOf( colors.onPrimary )
    }
    var homeColor by remember {
        mutableStateOf( colors.onPrimary )
    }
    var profileColor by remember {
        mutableStateOf( colors.onPrimary )
    }
    var storeColor by remember {
        mutableStateOf( colors.onPrimary )
    }

    val defaultBottomBar: @Composable () -> Unit = {
        BottomAppBar(
            navController,
            leadBoardColor,
            homeColor,
            profileColor,
            storeColor
        )
    }
    val backTopAppBar = @Composable {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.clickable(
                    onClick = { navController.popBackStack() }
                )
            )
        }
    }
    val defaultTopBar = @Composable {
        TopAppBar()
    }

    var bottomAppBar: @Composable () -> Unit by remember {
        mutableStateOf(defaultBottomBar)
    }
    var topAppBar: @Composable () -> Unit by remember {
        mutableStateOf(defaultTopBar)
    }

    Scaffold(
        bottomBar = bottomAppBar,
        topBar = topAppBar
    ) {
        NavHost(navController, "Home") {
            composable("Home") {
                bottomAppBar = defaultBottomBar
                topAppBar = defaultTopBar

                leadBoardColor = colors.onPrimary
                homeColor = colors.secondary
                profileColor = colors.onPrimary
                storeColor = colors.onPrimary

                HomeScreen(navController)

            }
            composable("Profile") {
                bottomAppBar = defaultBottomBar
                topAppBar = defaultTopBar

                leadBoardColor = colors.onPrimary
                homeColor = colors.onPrimary
                profileColor = colors.secondary
                storeColor = colors.onPrimary

                ProfileScreen()
            }
            composable("LeadBoard") {
                bottomAppBar = defaultBottomBar
                topAppBar = defaultTopBar

                leadBoardColor = colors.secondary
                homeColor = colors.onPrimary
                profileColor = colors.onPrimary
                storeColor = colors.onPrimary

                LeadBoardScreen()
            }
            composable("Store") {
                bottomAppBar = defaultBottomBar
                topAppBar = defaultTopBar

                leadBoardColor = colors.onPrimary
                homeColor = colors.onPrimary
                profileColor = colors.onPrimary
                storeColor = colors.secondary

                ShopScreen()
            }
            composable("SearchGame") {
                bottomAppBar = {}
                topAppBar = backTopAppBar

                SearchGame(navController)
            }
            composable("FriendlyOnlineGame") {
                bottomAppBar = {}
                topAppBar = backTopAppBar

                CreateOrJoinGame()
            }
            composable("GameScreen") {
                bottomAppBar = {}
                topAppBar = backTopAppBar

                GameScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun s() {
    val colors = MaterialTheme.colorScheme
    val brush = Brush.verticalGradient(listOf(colors.background, colors.primary))

    Scaffold(
        topBar = { TopAppBar() }
    ){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(brush))
    }
}

@Composable
fun TopAppBar() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val colors = MaterialTheme.colorScheme

    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(top = (screenHeight * 5 / 915).dp),
        horizontalArrangement = Arrangement.Absolute.Left,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(2f)) {
            CustomLinearProgressIndicator(
                progress = 0.7f,
                progressColor = colors.secondary,
                backgroundColor = Color.DarkGray,
                clipShape = CircleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height((screenHeight * 20 / 915).dp)

            )
            Text(
                text = "Level: 14",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier.weight(2f).clip(RoundedCornerShape(50)),
            contentAlignment = AbsoluteAlignment.CenterLeft
        ) {
            Box(
                modifier = Modifier
                    .height((screenHeight * 20 / 915).dp),
                contentAlignment = AbsoluteAlignment.CenterRight
            ) {
                Card(
                    modifier = Modifier.fillMaxSize(),
                    colors = CardDefaults.cardColors(colors.secondary),
                    shape = RoundedCornerShape(20)
                ) {
                    Text(
                        text = "100,000",
                        textAlign = TextAlign.Center,
                        color = colors.onSecondary,
                        fontSize = 15.sp,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Card(
                    modifier = Modifier
                        .size((screenHeight * 15 / 915).dp),
                    colors = CardDefaults.cardColors(Color.Green.copy(alpha = 0.6f)),
                    shape = CircleShape
                ) {
                    Text(
                        text = "+",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 12.sp,
                        modifier = Modifier.fillMaxSize()
                    )
                }

            }
            Image(
                painter = painterResource(id = R.drawable.coin),
                contentDescription = "coin",
                Modifier
                    .size((screenHeight * 20 / 915).dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun BottomAppBar(
    navController: NavController,
    leadBoardColor: Color,
    homeColor: Color,
    profileColor: Color,
    storeColor: Color
) {
    Row(horizontalArrangement = Arrangement.Absolute.Left) {
        Box(modifier = Modifier
            .weight(1f)
            .background(MaterialTheme.colorScheme.primary)
            .clickable(
                onClick = {
                    navController.navigate("Store")
                }
            ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.store),
                contentDescription = "Store",
                tint = storeColor
            )
        }
        Box(modifier = Modifier
            .weight(1f)
            .background(MaterialTheme.colorScheme.primary)
            .clickable(
                onClick = {
                    navController.navigate("LeadBoard")
                }
            ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.leaderboard),
                contentDescription = "LeadBoard",
                tint = leadBoardColor
            )
        }
        Box(modifier = Modifier
            .weight(1f)
            .background(MaterialTheme.colorScheme.primary)
            .clickable(
                onClick = {
                    navController.navigate("Home")
                }
            ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.Home,
                contentDescription = "Home",
                tint = homeColor
            )
        }
        Box(modifier = Modifier
            .weight(1f)
            .background(MaterialTheme.colorScheme.primary)
            .clickable(
                onClick = {
                    navController.navigate("Profile")
                }
            ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Account",
                tint = profileColor
            )
        }
    }
}