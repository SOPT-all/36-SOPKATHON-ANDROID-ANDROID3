package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun IngredientItem(
    imageUrl: String,
    ingredientName: String,
    ingredientAmount: String
    ){
    Row(modifier = Modifier.padding(16.dp)) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "재료 이미지",
            modifier = Modifier
                .size(54.dp)
                .clip(CircleShape)
        )
        Text(modifier = Modifier.padding(top = 12.dp), text = ingredientName)
        Text(modifier = Modifier.padding(top = 10.dp), text = ingredientAmount)
    }
}