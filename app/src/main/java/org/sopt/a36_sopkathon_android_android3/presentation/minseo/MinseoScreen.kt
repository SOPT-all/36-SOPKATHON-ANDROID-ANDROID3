package org.sopt.a36_sopkathon_android_android3.presentation.minseo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.a36_sopkathon_android_android3.presentation.component.TopBar
import org.sopt.a36_sopkathon_android_android3.presentation.minseo.component.ScrapInfoSection
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme


@Composable
fun MinseoRoute(
    navigateToJiwoo: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrapList = MinseoViewModel().scrapList

    MinseoScreen(
        scrapList = scrapList,
        navigateToJiwoo = navigateToJiwoo
    )
}

@Composable
private fun MinseoScreen(
    scrapList: List<ScrapInfo>,
    navigateToJiwoo: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ){
        TopBar(
            topBarText = "스크랩",
            onClickBack = navigateToJiwoo
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "총 " + scrapList.size + "개",
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "최신순"
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "필터"
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null
            )
        }

        LazyColumn(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            items(scrapList.size){ index ->
                ScrapInfoSection(
                    scrapInfo = scrapList[index]
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMinseoScreen() {
    HaeMuraTheme{
        MinseoScreen(
            scrapList = listOf(
                ScrapInfo(
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                    foodTitle = "들기름 막국수",
                    location = "경북 의성군 금성면",
                    level = "⭐️",
                    time = "⭐️⭐️⭐️"
                ),
                ScrapInfo(
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                    foodTitle = "들기름 막국수",
                    location = "경북 의성군 금성면",
                    level = "⭐️",
                    time = "⭐️⭐️⭐️"
                )
            ),
            navigateToJiwoo = {}
        )
    }
}