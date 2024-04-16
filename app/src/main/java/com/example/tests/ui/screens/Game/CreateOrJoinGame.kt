package com.example.tests.ui.screens.Game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(locale = "wi", device = "spec:width=1080px,height=2340px,dpi=640", showSystemUi = true)
@Composable
fun CreateOrJoinGame() {
    val colors = MaterialTheme.colorScheme
    val brush = Brush.verticalGradient(listOf(colors.background, colors.primary))
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp

    var text by remember {
        mutableStateOf("")
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(brush = brush)) {
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1f)
            .padding(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Create Room",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = screenHeight.value.sp*0.035,
                    textAlign = TextAlign.Center,
                    color = colors.onSecondary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colors.secondary)
                        .weight(1f)
                )
                Text(
                    text = "Open room\nReceive a code\nShare the code with your friends and play together",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = screenHeight.value.sp*0.02,
                    color = colors.onBackground,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(4f)
                )
                Spacer(modifier = Modifier.weight(2.2f))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = colors.primary),
                    modifier = Modifier.wrapContentSize()
                ) {
                    Text(
                        text = "Create",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = screenHeight.value.sp*0.03,
                        textAlign = TextAlign.Center,
                        color = colors.onPrimary,
                        modifier = Modifier
                    )
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1f)
            .padding(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Join Room",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = screenHeight.value.sp*0.035,
                    textAlign = TextAlign.Center,
                    color = colors.onSecondary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colors.secondary)
                        .weight(1f)
                )
                Text(
                    text = "Enter room code",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = screenHeight.value.sp*0.025,
                    color = colors.onPrimary,
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(4f)
                )
                TextField(
                    value = text,
                    onValueChange = {
                                    text = it
                    },
                    modifier = Modifier
                        .wrapContentSize()
                        .fillMaxWidth(0.9f),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = colors.onPrimary.copy(0.5f),
                        focusedContainerColor = colors.onPrimary,
                        focusedTextColor = colors.primary,
                        unfocusedTextColor = colors.primary
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    maxLines = 1,
                    placeholder = {
                        Text(
                            text = "Join Room",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = screenHeight.value.sp*0.02,
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        )
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = colors.onPrimary),
                    modifier = Modifier.wrapContentSize()
                ) {
                    Text(
                        text = "Join Room",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = screenHeight.value.sp*0.03,
                        textAlign = TextAlign.Center,
                        color = colors.primary
                    )
                }
            }
        }
    }
}