package com.example.tests.ui.screens.Game

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
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
            painter = painterResource(id = R.drawable.x1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(device = "spec:width=1080px,height=2340px,dpi=640")
@Composable
fun p() {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        dialog()
    }
}
@Composable
fun dialog() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    val colors = MaterialTheme.colorScheme

    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .wrapContentHeight()
                .background(colors.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Next round in: 3",
                fontWeight = FontWeight.Bold,
                fontSize = screenWidth.sp * 0.1,
                color = colors.onBackground
            )
            Spacer(modifier = Modifier.height((screenWidth/10).dp))
            ShowPlayersBar(
                modifier = Modifier
                    .wrapContentHeight()
                    .background(Color.Transparent),
                colors = colors,
                screenWidth = screenWidth
            )
            Spacer(modifier = Modifier.height((screenWidth/20).dp))
        }
    }
}

@Composable
private fun GameGrid(modifier: Modifier = Modifier) {
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
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Absolute.Left,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            Modifier.weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .size(((screenWidth - 40) / 4).dp),
                shape = RoundedCornerShape(20)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.xo2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20))
                )
            }
            Text(
                text = "Player 1",
                fontSize = screenWidth.sp * 0.05
            )
        }
        Card(
            colors = CardDefaults.cardColors(containerColor = colors.primary),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .height(((screenWidth - 40) / 3 / 3).dp)
                .weight(1f)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "1 : 2",
                    fontSize = screenWidth.sp * 0.04
                )
            }
        }
        Column(
            Modifier.weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .size(((screenWidth - 40) / 4).dp),
                shape = RoundedCornerShape(20)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.xo2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20))
                )
            }
            Text(
                text = "Player 2",
                fontSize = screenWidth.sp * 0.05
            )
        }
    }
}

@Preview(showSystemUi = true, device = "spec:width=1080px,height=2340px,dpi=640")
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
            modifier = Modifier.weight(2f),
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