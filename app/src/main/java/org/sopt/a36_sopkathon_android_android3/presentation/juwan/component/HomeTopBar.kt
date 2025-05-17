package org.sopt.a36_sopkathon_android_android3.presentation.juwan.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme


@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_marker),
            contentDescription = null
        )
        Text(
            text = "경상북도",
            style = HaeMuraTheme.typography.head_spc_16,
            color = HaeMuraTheme.colors.dark
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_hangari),
            contentDescription = "Scrap Icon"
        )

    }
}

@Preview
@Composable
fun previewtopbar() {
    HomeTopBar()
}