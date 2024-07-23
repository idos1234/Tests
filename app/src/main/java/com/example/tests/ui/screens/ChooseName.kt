package com.example.tests.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(device = "spec:width=1080px,height=2340px,dpi=480")
@Composable
fun ChooseNameScreen() {
    val colors = MaterialTheme.colorScheme
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Box(modifier = Modifier.fillMaxSize()) {
        SignInBackGround()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.3f))
            Text(
                text = "Choose your name",
                fontSize = screenHeight.value.sp * 0.05,
                color = colors.onBackground
            )

            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
            OutlinedTextField(
                value = "swdd",
                textStyle = TextStyle(
                    color = colors.onPrimary,
                    fontSize = screenHeight.value.sp * 0.03
                ),
                onValueChange = {},
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = colors.primary.copy(alpha = 0.3f),
                    focusedContainerColor = colors.primary,
                    focusedTextColor = colors.onPrimary,
                    unfocusedTextColor = colors.onPrimary,
                    focusedBorderColor = colors.onPrimary,
                    unfocusedBorderColor = colors.onPrimary
                ),
                modifier = Modifier
                    .fillMaxWidth(0.7f),
                shape = CircleShape
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.5f),
                shape = CircleShape
            ) {
                Text(
                    text = "Confirm",
                    fontSize = screenHeight.value.sp * 0.03,
                    color = colors.onBackground
                )
            }
        }
    }
}