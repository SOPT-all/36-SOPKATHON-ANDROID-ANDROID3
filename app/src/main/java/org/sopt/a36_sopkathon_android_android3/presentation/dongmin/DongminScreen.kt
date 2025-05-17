package org.sopt.a36_sopkathon_android_android3.presentation.dongmin

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.a36_sopkathon_android_android3.ui.theme._36SOPKATHONANDROIDANDROID3Theme

@Composable
fun DongminRoute(
    navigateToMinseo: () -> Unit,
    modifier: Modifier = Modifier
) {
    DongminScreen(
        navigateToMinseo = navigateToMinseo
    )
}

@Composable
private fun DongminScreen(
    navigateToMinseo: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Dongmin",
        modifier = modifier.clickable { navigateToMinseo() }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewMinseoScreen() {
    _36SOPKATHONANDROIDANDROID3Theme {
        DongminScreen(
            navigateToMinseo = {}
        )
    }
}