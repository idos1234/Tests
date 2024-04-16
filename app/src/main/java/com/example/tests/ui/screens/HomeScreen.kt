package com.example.tests.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Preview(showSystemUi = true, device = "spec:width=1080px,height=2340px,dpi=640")
@Composable
fun HomeScreen(navController: NavController = NavController(LocalContext.current)) {
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp

    val colors = MaterialTheme.colorScheme
    val type = MaterialTheme.typography
    val brush = Brush.verticalGradient(listOf(colors.background, colors.primary))


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(brush = brush)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        //"XO" text- Big
        Text(
            text = "xo",
            style = type.headlineLarge.copy(drawStyle = Stroke(width = 6f, join = StrokeJoin.Round)),
            fontSize = screenHeight.value.sp*0.25,
            color = colors.onBackground,
            textAlign = TextAlign.Center
        )
        //"Tic Tac Toe" text- Small
        Text(
            "Tic Tac Toe",
            color = colors.onBackground,
            fontSize = screenHeight.value.sp*0.02,
            )

        Spacer(modifier = Modifier.fillMaxHeight(0.2f))

        //the buttons
        Box {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxSize()
            ) {
                //training games button
                Button(
                    onClick = {
                              navController.navigate("GameScreen")
                    },
                    modifier = Modifier
                        .wrapContentSize()
                        .fillMaxWidth(0.5f),
                    colors = ButtonDefaults.buttonColors(containerColor = colors.primary)
                ) {
                    Text(
                        text = "Training",
                        fontSize = screenHeight.value.sp*0.03,
                        fontWeight = FontWeight.SemiBold,
                        color = colors.onPrimary
                    )
                }

                Spacer(modifier = Modifier.fillMaxHeight(0.1f))

                //online game button
                Button(
                    onClick = {navController.navigate("SearchGame")},
                    modifier = Modifier
                        .wrapContentSize()
                        .fillMaxWidth(0.5f),
                    colors = ButtonDefaults.buttonColors(containerColor = colors.primary)
                ) {
                    Text(
                        text = "Play",
                        style = type.bodyMedium,
                        fontSize = screenHeight.value.sp*0.03,
                        fontWeight = FontWeight.SemiBold,
                        color = colors.onPrimary
                    )
                }

                Spacer(modifier = Modifier.fillMaxHeight(0.1f))

                //online game button
                Button(
                    onClick = {navController.navigate("SearchGame")},
                    modifier = Modifier
                        .wrapContentSize()
                        .fillMaxWidth(0.7f),
                    colors = ButtonDefaults.buttonColors(containerColor = colors.primary)
                ) {
                    Text(
                        text = "Friendly Battle",
                        style = type.bodyMedium,
                        fontSize = screenHeight.value.sp*0.03,
                        fontWeight = FontWeight.SemiBold,
                        color = colors.onPrimary
                    )
                }
            }
        }

        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
    }
}