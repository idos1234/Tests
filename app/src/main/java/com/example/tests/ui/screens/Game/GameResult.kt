package com.example.tests.ui.screens.Game

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun GameResult(currentProgress: Float = 0.6f) {
    val colors = MaterialTheme.colorScheme
    val brush = Brush.verticalGradient(listOf(colors.background, colors.primary))

    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(brush),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Player1",
                        Modifier
                            .weight(1f)
                            .fillMaxSize(),
                        colorFilter = ColorFilter.tint(colors.onPrimary)
                    )
                    Text(
                        text = "Player 1",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f),
                        color = colors.onPrimary
                    )
                }
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Player2",
                        Modifier
                            .weight(1f)
                            .fillMaxSize(),
                        colorFilter = ColorFilter.tint(colors.onPrimary)
                    )
                    Text(
                        text = "Player 2",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f),
                        color = colors.onPrimary
                    )
                }
            }
            Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.Center) {
                MyProgressBar(
                    currentProgress = currentProgress,
                    colorScheme = colors
                )
            }
        }
    }
}

@Composable
fun MyProgressBar(currentProgress: Float, colorScheme: ColorScheme) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val currentPercentage = animateFloatAsState(
        targetValue =
    if(animationPlayed) currentProgress+0.1f else 0f,
        animationSpec = tween( durationMillis = 4000)
    )
    LaunchedEffect(key1 = true){
        animationPlayed=true
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(17.dp),
        contentAlignment = Alignment.Center
    ) {
        // Progress Bar
        LinearProgressIndicator(
            color = colorScheme.secondary,
            trackColor = Color.DarkGray,
            progress = currentPercentage.value,
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp)),
            )
        Text(
            text = "Level: 1 ",
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxHeight()
        )
    }
}