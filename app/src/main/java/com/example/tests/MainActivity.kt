package com.example.tests

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tests.ui.screens.Game.CreateOrJoinGame
import com.example.tests.ui.screens.Game.GameScreen
import com.example.tests.ui.screens.Game.SearchGame
import com.example.tests.ui.screens.Menu.CustomLinearProgressIndicator
import com.example.tests.ui.screens.Menu.HomeScreen
import com.example.tests.ui.screens.Menu.LeadBoardScreen
import com.example.tests.ui.screens.Menu.ProfileScreen
import com.example.tests.ui.theme.TestsTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            TestsTheme {
                startService(Intent(baseContext, ClearService::class.java))
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
                val defaultBottomBar: @Composable () -> Unit = {
                    BottomAppBar(
                        navController,
                        leadBoardColor,
                        homeColor,
                        profileColor
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
                            HomeScreen(navController)

                        }
                        composable("Profile") {
                            bottomAppBar = defaultBottomBar
                            topAppBar = defaultTopBar

                            leadBoardColor = colors.onPrimary
                            homeColor = colors.onPrimary
                            profileColor = colors.secondary
                            ProfileScreen()
                        }
                        composable("LeadBoard") {
                            bottomAppBar = defaultBottomBar
                            topAppBar = defaultTopBar

                            leadBoardColor = colors.secondary
                            homeColor = colors.onPrimary
                            profileColor = colors.onPrimary
                            LeadBoardScreen()
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
        }
    }
}

class ClearService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    override fun onDestroy() {}

    override fun onTaskRemoved(rootIntent: Intent?) {
        Log.e("Service", "END")
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
            .padding(10.dp)
            .fillMaxHeight(0.03f)
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.Absolute.Left,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            Modifier
                .fillMaxHeight()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            Box(
                modifier = Modifier.weight(1f).size(screenHeight.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = "8",
                    color = Color.Black,
                    fontSize = screenHeight.sp*0.01,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            }
            Box(
                modifier = Modifier.weight(4f),
                contentAlignment = Alignment.Center
            ) {
                CustomLinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize(0.9f)
                        .align(AbsoluteAlignment.CenterLeft),
                    clipShape = RoundedCornerShape(20.dp),
                    progressColor = colors.secondary,
                    backgroundColor = Color.DarkGray,
                    progress = 0.4f
                )
                Text(
                    text = "650/2003",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = screenHeight.sp*0.02
                    )
            }
        }

        Row(
            Modifier
                .fillMaxHeight()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.Green),
                shape = RoundedCornerShape(20),
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "+",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = screenHeight.sp*0.02
                        )
                }
            }
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.DarkGray.copy(0.6f)),
                shape = RectangleShape,
                modifier = Modifier
                    .weight(4f)
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Absolute.Left,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "2000",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(3f),
                            fontSize = screenHeight.sp*0.02,
                            )
                        Image(
                            painter = painterResource(id = R.drawable.coin),
                            contentDescription = null,
                            Modifier
                                .size(screenHeight.dp)
                                .weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomAppBar(
    navController: NavController,
    leadBoardColor: Color,
    homeColor: Color,
    profileColor: Color
) {
    Row(horizontalArrangement = Arrangement.Absolute.Left) {
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