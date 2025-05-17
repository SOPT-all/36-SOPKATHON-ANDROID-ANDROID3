package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun RecipeOverview(
    ownerImageUrl: String,
    ownerName: String,
    ownerResidence : String,
    recipeTitle: String,
    difficulty: Int,
    time: String
) {
    Column {
        Row {
            AsyncImage(
                model = ownerImageUrl,
                contentDescription = "사용자 이미지",
                modifier = Modifier
                    .size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = ownerName
            )
        }
        Spacer(modifier = Modifier.width(6.dp))

        Row {
            Column {
                Text(
                    text = ownerResidence
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = recipeTitle
                )
            }
            Row {
                // Icon 아직
            }
        }
        Row {
            Text(text = "난이도: $difficulty", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "시간: $time", style = MaterialTheme.typography.bodySmall)
        }
    }
}