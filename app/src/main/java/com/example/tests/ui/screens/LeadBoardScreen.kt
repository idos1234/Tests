package com.example.tests.ui.screens

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tests.data.Player

@Preview(device = "spec:width=1080px,height=2340px,dpi=640")
@Composable
fun LeadBoardScreen() {
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    val colors = MaterialTheme.colorScheme
    val brush = Brush.verticalGradient(listOf(colors.background, colors.primary))
    //max chars: 10
    var players: List<Player> = listOf(
        Player("##########", 200),
        Player("Noa", 150),
        Player("Lilach", 210),
        Player("Tal", 100),
        Player("Sharon", 50),
        Player("Yaron", 125)
    )

    players = players.sortedByDescending { it.score }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(brush = brush),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "LeaderBoard",
            color = colors.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = screenHeight.value.sp*0.05,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(screenHeight.value.times(0.05).dp))
        
        Card(
            modifier = Modifier
                .fillMaxSize(0.8f),
            colors = CardDefaults.cardColors(containerColor = colors.primary)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = screenHeight.value.times(0.05).dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                players.take(100).forEachIndexed { index, player ->
                    item {
                        ShowPlayer(
                            player = player,
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                                .background(Color.Transparent)
                                .height(screenHeight.value.times(0.05).dp)
                                .padding(5.dp)
                                .align(Alignment.CenterHorizontally),
                            index + 1,
                            colors,
                            screenHeight,
                            screenWidth
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(screenHeight.value.times(0.05).dp))
    }
}

@Composable
fun ShowPlayer(player: Player, modifier: Modifier, index: Int, colorScheme: ColorScheme, screenHeight: Dp, screenWidth: Dp) {
    val color = if(index == 1) {
        Color(0xFFFFC400)
    } else {
        colorScheme.onPrimary
    }

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = color),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left
                ) {
                    Text(
                        "$index",
                        fontSize = screenHeight.value.sp*0.02,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                    Text(
                        ".",
                        fontSize = screenHeight.value.sp*0.02,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                    Image(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Image",
                        modifier = Modifier.size(((screenWidth.value*0.8-60)/6/2).dp)
                    )
                }
            }
            Box(
                modifier = Modifier.wrapContentSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    player.name,
                    fontSize = screenHeight.value.sp*0.02,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    player.score.toString(),
                    fontSize = screenHeight.value.sp*0.02,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}