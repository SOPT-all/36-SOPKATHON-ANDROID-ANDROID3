package org.sopt.a36_sopkathon_android_android3.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.a36_sopkathon_android_android3.R

@Composable
fun StarCount(count: Int) {
    Row {
        for (i in 1..5) {
            if (i <= count) {
                Image(
                    painter = painterResource(id = R.drawable.red_star),
                    contentDescription = null,
                    modifier = Modifier.size(12.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.brown_star),
                    contentDescription = null,
                    modifier = Modifier.size(12.dp)
                )
            }
        }

    }
}
