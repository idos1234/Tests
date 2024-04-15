package com.example.tests.ui.screens.Game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tests.R


@Composable
private fun GameButton(modifier: Modifier = Modifier) {
    val colors = MaterialTheme.colorScheme

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    Card(
        shape = RoundedCornerShape(20),
        modifier = modifier
            .padding(5.dp)
            .size(((screenWidth - 20 - 30) / 3).dp)
            .background(Color.Transparent),
        border = BorderStroke(1.dp, colors.onPrimary),
        colors = CardDefaults.cardColors(containerColor = colors.primary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.x_1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun GameGrid(modifier: Modifier = Modifier) {
    MaterialTheme.colorScheme

    Column(
        modifier = modifier
            .background(Color.Transparent)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            GameButton(Modifier.weight(1f))
            GameButton(Modifier.weight(1f))
            GameButton(Modifier.weight(1f))
        }

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            GameButton(Modifier.weight(1f))
            GameButton(Modifier.weight(1f))
            GameButton(Modifier.weight(1f))
        }

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            GameButton(Modifier.weight(1f))
            GameButton(Modifier.weight(1f))
            GameButton(Modifier.weight(1f))
        }
    }
}

@Composable
private fun ShowPlayersBar(modifier: Modifier, colors: ColorScheme, screenWidth: Int) {
    Box(
        modifier = modifier
            .fillMaxSize(0.9f),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    shape = RoundedCornerShape(20),
                    modifier = Modifier
                        .background(Color.Transparent),
                    colors = CardDefaults.cardColors(containerColor = colors.primary)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.xo_2),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size((screenWidth * 0.9 / 3 - 15).dp)
                                .padding(5.dp)
                                .clip(CircleShape)
                        )
                        Text("Player1", fontSize = 20.sp)
                        Text("Score: 1", fontSize = 20.sp, modifier = Modifier.padding(5.dp))
                    }
                }

            }
            Text(
                text = "VS",
                textAlign = TextAlign.Center,
                color = colors.onBackground,
                fontSize = 30.sp,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    shape = RoundedCornerShape(20),
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(5.dp),
                    colors = CardDefaults.cardColors(containerColor = colors.primary)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.xo_2),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size((screenWidth * 0.9 / 3 -15).dp)
                                .clip(CircleShape)
                        )
                        Text("Player2", fontSize = 20.sp)
                        Text("Score: 1", fontSize = 20.sp, modifier = Modifier.padding(5.dp))
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun GameScreen() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    val colors = MaterialTheme.colorScheme
    val brush = Brush.verticalGradient(listOf(colors.background, colors.primary))

    Column(
        Modifier
            .fillMaxSize()
            .background(brush = brush),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ShowPlayersBar(
            modifier = Modifier.weight(3f),
            colors = colors,
            screenWidth = screenWidth
        )
        GameGrid(
            Modifier
                .padding(10.dp)
                .weight(3f)
                .fillMaxSize()
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}