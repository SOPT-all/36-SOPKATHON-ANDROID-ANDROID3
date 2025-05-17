package org.sopt.a36_sopkathon_android_android3.presentation.component

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.sopt.a36_sopkathon_android_android3.R
import java.lang.Math.PI
import kotlin.math.sin

@Composable
fun LoadingIcons(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(3) { index ->
            LoadingIcon(index)
        }
    }


}

@Composable
private fun LoadingIcon(
    delay: Int = 0
) {
    val scope = rememberCoroutineScope()
    val shakeDegrees = remember { Animatable(0f) }
    val height = remember { Animatable(0f) }

    // 무한 애니메이션 실행
    LaunchedEffect(Unit) {
        scope.launch {

        delay(delay.toLong() * 200)

        while (true) {
            val duration = 2000
            val startTime = withFrameNanos { it }
            var time: Long

            do {
                time = withFrameNanos { it }
                val elapsed = (time - startTime) / 1_000_000 // ms
                val progress = elapsed / duration.toFloat()

                val angle = sin(progress * 20 * PI).toFloat() * 10f // 좌우 흔들림
                val vertical = sin(progress * 4 * PI).toFloat() * 20f // 위아래 흔들림

                shakeDegrees.snapTo(angle)
                height.snapTo(vertical)
            } while (elapsed < duration)
        }

        }
    }

    Image(
        painter = painterResource(R.drawable.hangari),
        contentDescription = null,
        modifier = Modifier
            .size(50.dp)
            .graphicsLayer {
                rotationZ = shakeDegrees.value
                translationY = height.value
            }
    )
}
