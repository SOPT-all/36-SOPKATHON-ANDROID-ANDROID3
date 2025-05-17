package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun IngredientCard(
    recommendImg: String,
    recommendShopName: String,
    recommendName: String,
    recommendPrice: String
){
    Row(modifier = Modifier.padding(16.dp)) {
        AsyncImage(
            model = recommendImg,
            contentDescription = "특산물 이미지",
            modifier = Modifier
                .size(width = 96.dp, height = 128.dp)
        )
        Text(modifier = Modifier.padding(top = 12.dp), text = recommendShopName)
        Text(modifier = Modifier.padding(top = 12.dp), text = recommendName)
        Text(modifier = Modifier.padding(top = 10.dp), text = recommendPrice)
    }
}