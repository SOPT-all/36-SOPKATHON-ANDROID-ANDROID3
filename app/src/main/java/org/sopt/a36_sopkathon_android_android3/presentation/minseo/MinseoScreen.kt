package org.sopt.a36_sopkathon_android_android3.presentation.minseo

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.a36_sopkathon_android_android3.ui.theme._36SOPKATHONANDROIDANDROID3Theme

@Composable
fun MinseoRoute(
    navigateToJiwoo: () -> Unit,
    modifier: Modifier = Modifier
) {
    MinseoScreen(
        navigateToJiwoo = navigateToJiwoo
    )
}

@Composable
private fun MinseoScreen(
    navigateToJiwoo: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Minseo",
        modifier = modifier.clickable { navigateToJiwoo() }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewMinseoScreen() {
    _36SOPKATHONANDROIDANDROID3Theme {
        MinseoScreen(
            navigateToJiwoo = {}
        )
    }
}