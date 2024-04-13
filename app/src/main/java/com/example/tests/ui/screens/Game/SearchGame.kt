package com.example.tests.ui.screens.Game


import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tests.R


@Composable
fun SearchGame(navController: NavHostController) {
    BackHandler {
        navController.navigateUp()
    }


    val configuration = LocalConfiguration.current

    val screenWidth = configuration.screenWidthDp.dp
    val colors = MaterialTheme.colorScheme
    val brush = Brush.verticalGradient(listOf(colors.background, colors.primary))


    val rotationState = rememberInfiniteTransition()
    val rotation by rotationState.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 5000
                0f at 0 with LinearEasing
                360f at 5000 with LinearEasing
            },
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = brush), contentAlignment = Alignment.Center) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cloud),
                contentDescription = "Search",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(0.12f),
                tint = colors.primary
            )
            Icon(
                painter = painterResource(id = R.drawable.cloud),
                contentDescription = "Search",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(0.15f),
                tint = colors.primary
            )
            Icon(
                painter = painterResource(id = R.drawable.cloud),
                contentDescription = "Search",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(0.1f),
                tint = colors.primary
            )
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = size.width / 4
            val amplitude = size.width / 8

            val angle = Math.toRadians(rotation.toDouble())
            val x = centerX + (radius * Math.cos(angle)).toFloat()
            val y = centerY + (amplitude * Math.sin(angle * 2)).toFloat()

            val iconSize = (screenWidth.value / 2).dp
            val strokeWidth = 10f
            val glassSize = iconSize.value / 2

            drawCircle(
                color = colors.onPrimary,
                radius = glassSize,
                center = Offset(x, y),
                style = Stroke(width = strokeWidth)
            )
            drawCircle(
                color = colors.onPrimary,
                radius = glassSize,
                center = Offset(x, y),
                colorFilter = ColorFilter.tint(Color.White.copy(0.5f))
            )

            drawLine(
                color = colors.onPrimary,
                start = Offset(x + glassSize / 2, y + glassSize / 2),
                end = Offset(x + glassSize * 1.5f, y + glassSize * 1.5f),
                strokeWidth = strokeWidth
            )
        }
    }
}