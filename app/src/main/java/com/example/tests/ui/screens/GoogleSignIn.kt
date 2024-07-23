package com.example.tests.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.base.R

@Composable
fun SignInBackGround() {

    val colors = MaterialTheme.colorScheme
    val brush = Brush.verticalGradient(listOf(colors.background, colors.primary))
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = AbsoluteAlignment.TopLeft
        ) {
            Text(
                text = "X",
                fontSize = screenHeight.value.sp * 0.3,
                color = colors.onBackground.copy(0.3f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.rotate(35f)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "O",
                fontSize = screenHeight.value.sp * 0.3,
                color = colors.onBackground.copy(0.3f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.rotate(35f)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = AbsoluteAlignment.BottomRight
        ) {
            Text(
                text = "X",
                fontSize = screenHeight.value.sp * 0.3,
                color = colors.onBackground.copy(0.3f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.rotate(35f)
            )
        }
    }
}

@Preview(device = "spec:width=1080px,height=2340px,dpi=480", showSystemUi = true
)
@Composable
fun GoogleSignInScreen() {
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
            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
            Row(
                horizontalArrangement = Arrangement.Absolute.Left,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Welcome",
                    fontSize = screenHeight.value.sp * 0.07,
                    color = colors.onBackground
                )
                Text(
                    text = "!",
                    fontSize = screenHeight.value.sp * 0.07,
                    color = colors.onBackground
                )
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.4f))
            GoogleSignInButton(modifier = Modifier.fillMaxWidth(0.7f))
        }
    }
}

@Composable
private fun GoogleSignInButton(modifier: Modifier) {
    val colors = MaterialTheme.colorScheme
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    OutlinedButton(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colors.primary),
        border = BorderStroke(1.dp, colors.onPrimary),
        modifier = modifier,
        shape = CircleShape
    ) {
        Row(
            horizontalArrangement = Arrangement.Absolute.Left,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.googleg_standard_color_18),
                contentDescription = "google sign in icon"
            )
            Text(
                text = "Sign up with Google",
                fontSize = screenHeight.value.sp * 0.02,
                color = colors.onBackground
            )
        }
    }
}