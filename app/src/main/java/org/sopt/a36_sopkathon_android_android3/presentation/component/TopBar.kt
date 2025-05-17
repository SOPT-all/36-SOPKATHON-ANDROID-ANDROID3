package org.sopt.a36_sopkathon_android_android3.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme


@Composable
fun TopBar(
    topBarText: String,
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier,
    trailingIconVisible: Boolean = false,
) {
    Row(
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            modifier = Modifier.clickable { onClickBack() }
        )

        Text(
            text = topBarText,
            modifier = Modifier.padding(start = 10.dp)
        )

        if (trailingIconVisible) {
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopBar() {
    HaeMuraTheme {
        TopBar(
            topBarText = "TopBar",
            onClickBack = {}
        )
    }
}