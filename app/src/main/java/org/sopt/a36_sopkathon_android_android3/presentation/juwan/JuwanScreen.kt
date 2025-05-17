package org.sopt.a36_sopkathon_android_android3.presentation.juwan

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.a36_sopkathon_android_android3.ui.theme._36SOPKATHONANDROIDANDROID3Theme

@Composable
fun JuwanRoute(
    navigateToDongmin: () -> Unit,
    modifier: Modifier = Modifier
) {
    JuwanScreen(
        navigateToDongmin = navigateToDongmin
    )
}

@Composable
private fun JuwanScreen(
    navigateToDongmin: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Juwan",
        modifier = modifier.clickable { navigateToDongmin() }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewJuwanScreen() {
    _36SOPKATHONANDROIDANDROID3Theme {
        JuwanScreen(
            navigateToDongmin = {}
        )
    }
}