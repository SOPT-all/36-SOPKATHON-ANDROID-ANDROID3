package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component

import android.R.attr.contentDescription
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.colors
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.typography

@Composable
fun IngredientCard(
    recommendImg: String,
    recommendShopName: String,
    recommendName: String,
    recommendPrice: String
) {
    Column(
        modifier = Modifier.padding(end = 16.dp)
    ) {
        AsyncImage(
            model = recommendImg,
            contentDescription = "특산물 이미지",
            modifier = Modifier
                .size(width = 96.dp, height = 128.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = recommendShopName,
            style = typography.caption_10M,
            color = colors.light
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = recommendName,
            style = typography.caption_12R,
            color = colors.dark
        )
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = recommendPrice,
            style = typography.body_spc_12,
            color = colors.dark
        )
    }
}