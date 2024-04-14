package com.example.tests

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tests.ui.screens.Game.SearchGame
import com.example.tests.ui.screens.HomeScreen
import com.example.tests.ui.screens.LeadBoardScreen
import com.example.tests.ui.screens.ProfileScreen
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

                var bottomAppBar: @Composable () -> Unit by remember {
                    mutableStateOf(defaultBottomBar)
                }

                Scaffold(
                    bottomBar = bottomAppBar,
                ) {
                    NavHost(navController, "Home") {
                        composable("Home") {
                            bottomAppBar = defaultBottomBar

                            leadBoardColor = colors.onPrimary
                            homeColor = colors.secondary
                            profileColor = colors.onPrimary
                            HomeScreen(navController)

                        }
                        composable("Profile") {
                            bottomAppBar = defaultBottomBar

                            leadBoardColor = colors.onPrimary
                            homeColor = colors.onPrimary
                            profileColor = colors.secondary
                            ProfileScreen()
                        }
                        composable("LeadBoard") {
                            bottomAppBar = defaultBottomBar

                            leadBoardColor = colors.secondary
                            homeColor = colors.onPrimary
                            profileColor = colors.onPrimary
                            LeadBoardScreen()
                        }
                        composable("SearchGame") {
                            bottomAppBar = {}

                            SearchGame(navController)
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
fun BottomAppBar(
    navController: NavController,
    leadBoardColor: Color,
    homeColor: Color,
    profileColor: Color
) {
    Row {
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