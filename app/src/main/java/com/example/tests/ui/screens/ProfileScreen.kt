package com.example.tests.ui.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tests.R
import com.example.tests.data.Game

@Preview
@Composable
fun ProfileScreen() {
    val scoreFromCurrentLevel = 0
    val score = 8
    val scoreToNextLevel = 10
    val progress:Float = (score-scoreFromCurrentLevel)/(scoreToNextLevel-scoreFromCurrentLevel).toFloat()

    val colors = MaterialTheme.colorScheme
    val brush = Brush.verticalGradient(listOf(colors.background, colors.primary))

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    val level = 1
    val name = "Ido"

    val games:List<Game> = listOf(
        Game(
            "Ido",
            "Noa",
            "Ido",
            2,
            1
        ),
        Game(
            "Ido",
            "Tal",
            "Tal",
            0,
            2
        ),
        Game(
            "Sharon",
            "Ido",
            "Ido",
            1,
            2
        ),
        Game(
            "Noa",
            "Ido",
            "Noa",
            2,
            0
        ),
        Game(
            "Ido",
            "Lilach",
            "Lilach",
            0,
            2
        )
    )


    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(brush = brush)
    ) {
        item {
            //player's data - name, image, wins, loses
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(16.dp),
                colors = CardDefaults.cardColors(colors.primary),
                elevation = CardDefaults.cardElevation(20.dp),
                shape = RoundedCornerShape(40.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Left,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .size(150.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        //image
                        Box(modifier = Modifier
                            .fillMaxSize(0.7f)
                            .weight(2f),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.xo_1),
                                contentDescription = "Player's image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(CircleShape)
                            )
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit",
                                tint = Color.Black
                            )
                        }
                        //x and o
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Absolute.Left,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize(0.7f)
                                .padding(5.dp)
                        ) {
                            //x
                            Card(modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 2.5.dp),
                                shape = CircleShape,
                                elevation = CardDefaults.cardElevation(8.dp),
                                colors = CardDefaults.cardColors(containerColor = colors.onPrimary)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.x_1),
                                    contentDescription = "Player's image",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            //o
                            Card(modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 2.5.dp),
                                shape = CircleShape,
                                elevation = CardDefaults.cardElevation(8.dp),
                                colors = CardDefaults.cardColors(containerColor = colors.onPrimary)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.o_1),
                                    contentDescription = "Player's image",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        //name
                        Text(
                            text = name,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = colors.onBackground
                        )

                        Box(modifier = Modifier.padding(top = 16.dp)) {
                            //wins
                            Column {
                                Text(
                                    text = "Wins: 13",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = colors.onBackground
                                )
                                //loses
                                Text(
                                    text = "Loses: 7",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = colors.onBackground
                                )
                            }
                        }
                    }
                }
            }
        }

        //progress to the next rank
        item {
            Box(modifier = Modifier.fillMaxWidth(0.9f)) {
                Column(Modifier.fillMaxWidth()) {
                    //progress line
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        LinearProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(15.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            color = colors.secondary,
                            trackColor = Color.DarkGray,
                            progress = { progress },
                            strokeCap = StrokeCap.Round,
                        )
                        Text(
                            text = "Level: $level",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        ) {
                        //stars from this level
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.95f)
                                .weight(1f),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Absolute.Left
                            ) {
                                Text(
                                    text = scoreFromCurrentLevel.toString(),
                                    fontSize = 20.sp,
                                    color = colors.secondary,
                                )
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "Star",
                                    tint = Color.Yellow
                                )
                            }
                        }
                        //stars to next level
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.95f)
                                .weight(1f),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Absolute.Left
                                ) {
                                Text(
                                    text = scoreToNextLevel.toString(),
                                    fontSize = 20.sp,
                                    color = colors.secondary,
                                )
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "Star",
                                    tint = Color.Yellow
                                )
                            }
                        }
                    }
                }
            }
        }

        //last games
        item {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
            ) {
                Spacer(modifier = Modifier.height(60.dp))

                Row(
                    horizontalArrangement = Arrangement.Absolute.Left,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Last games",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500,
                        color = colors.onBackground,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Left
                    )
                    TextButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.weight(1f),
                    ) {
                        Text(
                            text = "More",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W500,
                            color = colors.secondary,
                            textAlign = TextAlign.Right,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                Box {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = (screenWidth * 0.4).dp),
                        modifier = Modifier
                            .height(screenWidth.dp),
                        horizontalArrangement = Arrangement.Absolute.Left
                    ) {
                        items(games.take(4)) {
                            ShowGame(
                                modifier = Modifier
                                    .size((screenWidth * 0.4).dp)
                                    .padding(5.dp),
                                game = it,
                                colorScheme = colors,
                                name = name
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShowGame(modifier: Modifier, game: Game, colorScheme: ColorScheme, name: String) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    val color = if(name != game.winner) {
        Color(0xFFB82039)
    } else {
        Color(0xFF33C048)
    }

    Card(
        modifier = modifier.background(Color.Transparent),
        colors = CardDefaults.cardColors(colorScheme.primary),
        border = BorderStroke(5.dp, Color.Black)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.fillMaxSize(0.9f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f))
                //players' names
                Row(
                    horizontalArrangement = Arrangement.Absolute.Left,
                    modifier = Modifier.weight(1f)
                ) {
                    //player 1 name
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = game.player1,
                            fontSize = screenHeight.value.sp * 0.015,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraBold,
                            color = colorScheme.onPrimary
                        )
                    }
                    //player 2 name
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = game.player2,
                            fontSize = screenHeight.value.sp * 0.015,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraBold,
                            color = colorScheme.onPrimary
                        )
                    }
                }
                //players' score
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Absolute.Left
                    ) {
                    //player 1 score
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = game.player1Score.toString(),
                            fontSize = screenHeight.value.sp * 0.015,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraBold,
                            color = colorScheme.onPrimary
                        )
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(0.5f)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "-",
                            fontSize = screenHeight.value.sp * 0.015,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraBold,
                            color = colorScheme.onPrimary
                        )
                    }
                    //player 2 score
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = game.player2Score.toString(),
                            fontSize = screenHeight.value.sp * 0.015,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraBold,
                            color = colorScheme.onPrimary
                        )
                    }
                }
                //line shows if player won or lost
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .clip(RoundedCornerShape(20.dp)),
                    color = color,
                    trackColor = color,
                    progress = { 1f }
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}