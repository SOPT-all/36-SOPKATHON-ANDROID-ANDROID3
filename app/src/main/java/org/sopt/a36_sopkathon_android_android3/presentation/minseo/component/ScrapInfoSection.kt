package org.sopt.a36_sopkathon_android_android3.presentation.minseo.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.presentation.component.StarCount
import org.sopt.a36_sopkathon_android_android3.presentation.minseo.ScrapInfo
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.colors
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.typography


@Composable
fun ScrapInfoSection(
    scrapInfo: ScrapInfo,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(color = colors.white, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 14.dp)
            .fillMaxWidth()
    ){
        AsyncImage(
            model = scrapInfo.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(75.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))

        Column{
            Text(
                text = scrapInfo.location,
                style = typography.body_spc_12,
                color = colors.dark
            )
            Text(
                text = scrapInfo.foodTitle,
                style = typography.head_spc_16,
                color = colors.dark
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row {
                Text(
                    text = "난이도: ",
                    modifier = Modifier.padding(end = 8.dp),
                    style = typography.body_spc_12,
                    color = colors.light
                )
                StarCount(scrapInfo.level)
                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "시간: ",
                    style = typography.body_spc_12,
                    color = colors.light
                )
                Text(
                    text = scrapInfo.time,
                    style = typography.caption_12R,
                    color = colors.dark
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_home_hangari),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = colors.dark
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewScrapInfoSection() {
    HaeMuraTheme {
        ScrapInfoSection(
            scrapInfo =
                ScrapInfo(
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                    foodTitle = "들기름 막국수",
                    location = "경북 의성군 금성면",
                    level = 1,
                    time = "⭐️⭐️⭐️"
                )

        )
    }
}