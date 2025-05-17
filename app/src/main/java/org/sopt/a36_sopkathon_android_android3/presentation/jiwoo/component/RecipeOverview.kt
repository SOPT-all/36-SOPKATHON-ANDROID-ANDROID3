package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.presentation.component.StarCount
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.colors
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.typography

@Composable
fun RecipeOverview(
    ownerImageUrl: String,
    ownerName: String,
    ownerResidence : String,
    recipeTitle: String,
    difficulty: Int,
    time: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ownerImageUrl,
                contentDescription = "사용자 이미지",
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = ownerName,
                style = typography.body_spc_12,
                color = colors.dark
            )
        }
        Spacer(modifier = Modifier.width(6.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Column {
                Text(
                    text = ownerResidence,
                    style = typography.head_spc_16,
                    color = colors.dark
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = recipeTitle,
                    style = typography.head_spc_24,
                    color = colors.dark
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_scrap),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    imageVector = ImageVector.vectorResource(id= R.drawable.ic_share),
                    contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "난이도: ",
                style = typography.body_spc_12,
                color = colors.dark
            )
            StarCount(count = difficulty)
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "시간: ",
                style = typography.body_spc_12,
                color = colors.dark
            )
            Text(
                text = time,
                style = typography.caption_12R,
                color = colors.dark
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    HaeMuraTheme {
        RecipeOverview(
            ownerImageUrl = "ㅋㅋ",
            ownerName = " ㅗㅗ",
            ownerResidence = "ㅗㅗ",
            recipeTitle = "ㅋㅋ",
            difficulty = 3,
            time = "35분"
        )
    }
    
}
