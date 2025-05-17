package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme


@Composable
fun JiwooRoute(
    navigateToJuwan: () -> Unit,
    modifier: Modifier = Modifier
) {
    JiwooScreen(
        navigateToJuwan = navigateToJuwan
    )
}

@Composable
private fun JiwooScreen(
    navigateToJuwan: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Jiwoo",
        modifier = modifier.clickable { navigateToJuwan() }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewJiwooScreen() {
    HaeMuraTheme {
        JiwooScreen(
            navigateToJuwan = {}
        )
    }
}