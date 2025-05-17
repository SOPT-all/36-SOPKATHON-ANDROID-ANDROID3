package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Review(
    imageUrl: String,
    content: String
) {
    Row(modifier = Modifier.padding(8.dp)) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "리뷰 이미지"
        )
        Text(text = content)
    }
}