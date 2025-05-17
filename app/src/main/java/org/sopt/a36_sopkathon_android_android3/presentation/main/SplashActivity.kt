package org.sopt.a36_sopkathon_android_android3.presentation.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaemuraFont

@SuppressLint("CustomSplashScreen")
class SplashActivity(): ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HaeMuraTheme {
                SplashScreen(
                    onFinish =  {
                        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
private fun SplashScreen(
    onFinish: () -> Unit,
) {
    var isVisible by remember { mutableStateOf(false) }
    var isVisibleText by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(1000)
        isVisible = true

        delay(1000)
        isVisibleText = true

        onFinish()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFDE2)),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_top),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )

            AnimatedVisibility(
                visible = isVisible,
                enter = slideIn(
                    initialOffset = { fullSize -> IntOffset(fullSize.width, fullSize.height) },
                    animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
                ) + fadeIn(animationSpec = tween(500))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fork),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .offset(
                            x = 25.dp,
                            y = 35.dp
                        )
                )
            }
        }

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(500))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(2f))
                AnimatedVisibility(
                    visible = isVisible,
                    enter = fadeIn(animationSpec = tween(500))
                ) {
                    Text(
                        text = "해무라",
                        color = Color(0xFF000000),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    HaeMuraTheme {
        SplashScreen(
            onFinish = {}
        )
    }
}
