package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component

import android.R.attr.top
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.colors
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.typography

@Composable
fun IngredientItem(
    imageUrl: Int,
    ingredientName: String,
    ingredientAmount: String
    ){
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageUrl),
            contentDescription = "재료 이미지",
            modifier = Modifier
                .size(54.dp)
                .clip(CircleShape)
        )
        Text(
            text = ingredientName,
            style = typography.body_spc_12,
            color = colors.dark,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = ingredientAmount,
            style = typography.caption_10M,
            color = colors.light,
            modifier = Modifier.padding(top = 4.dp),
        )
    }
}