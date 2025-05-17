package org.sopt.a36_sopkathon_android_android3.presentation.minseo.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.a36_sopkathon_android_android3.presentation.minseo.ScrapInfo
import org.sopt.a36_sopkathon_android_android3.ui.theme._36SOPKATHONANDROIDANDROID3Theme

@Composable
fun ScrapInfoSection(
    scrapInfo: ScrapInfo,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(color = Gray, shape = RoundedCornerShape(15.dp))
            .padding(20.dp)
            .fillMaxWidth()
    ){
        AsyncImage(
            model = scrapInfo.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
        )

        Column{
            Text(
                text = scrapInfo.title,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            Text(
                text = scrapInfo.content
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewScrapInfoSection() {
    _36SOPKATHONANDROIDANDROID3Theme {
        ScrapInfoSection(
            scrapInfo =
                ScrapInfo(
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                    title = "들기름 막국수",
                    content = "맛있어요"
                )

        )
    }
}