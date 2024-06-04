package com.example.tests.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tests.R

@Composable
fun XOTest() {

    LazyColumn {
        item {
            ShowX()
        }

        item {
            ShowO()
        }
    }

}


@Preview
@Composable
fun ShowX(modifier: Modifier = Modifier) {
    var image by remember {
        mutableIntStateOf(R.drawable.x1)
    }
    val X = listOf(
        R.drawable.x1,
        R.drawable.x2,
        R.drawable.x3,
        R.drawable.x4,
        R.drawable.x5,
        R.drawable.x6,
        R.drawable.x7,
        R.drawable.x8,
        R.drawable.x9,
        R.drawable.x10,
        R.drawable.x11,
        R.drawable.x12,
        R.drawable.x13,
        R.drawable.x14,
        R.drawable.x15
    )

    val colors = MaterialTheme.colorScheme

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    Column(
        modifier = modifier
            .background(colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(20),
            modifier = Modifier
                .padding(5.dp)
                .size(((screenWidth - 20 - 30) / 3).dp)
                .background(Color.Transparent),
            border = BorderStroke(1.dp, colors.onPrimary),
            colors = CardDefaults.cardColors(containerColor = colors.primary)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        LazyVerticalGrid(columns = GridCells.Fixed(4), modifier = Modifier.size(screenWidth.dp)) {
            X.forEach {
                item {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        modifier = Modifier
                            .size(screenWidth.dp / 4)
                            .border(1.dp, colors.onBackground)
                            .clickable(
                                onClick = { image = it }
                            )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ShowO(modifier: Modifier = Modifier) {
    var image by remember {
        mutableIntStateOf(R.drawable.o1)
    }

    val O = listOf(
        R.drawable.o1,
        R.drawable.o2,
        R.drawable.o3,
        R.drawable.o4,
        R.drawable.o5,
        R.drawable.o6,
        R.drawable.o7,
        R.drawable.o8,
        R.drawable.o9,
        R.drawable.o10,
        R.drawable.o11,
        R.drawable.o12,
        R.drawable.o13,
        R.drawable.o14,
        R.drawable.o15
    )

    val colors = MaterialTheme.colorScheme

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    Column(
        modifier = modifier
            .background(colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(20),
            modifier = Modifier
                .padding(5.dp)
                .size(((screenWidth - 20 - 30) / 3).dp)
                .background(Color.Transparent),
            border = BorderStroke(1.dp, colors.onPrimary),
            colors = CardDefaults.cardColors(containerColor = colors.primary)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        LazyVerticalGrid(columns = GridCells.Fixed(4), modifier = Modifier.size(screenWidth.dp)) {
            O.forEach {
                item {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        modifier = Modifier
                            .size(screenWidth.dp / 4)
                            .border(1.dp, colors.onBackground)
                            .clickable(
                                onClick = { image = it }
                            )
                    )
                }
            }
        }
    }
}