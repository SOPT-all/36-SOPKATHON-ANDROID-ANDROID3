package org.sopt.a36_sopkathon_android_android3.presentation.minseo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.presentation.component.TopBar
import org.sopt.a36_sopkathon_android_android3.presentation.minseo.component.ScrapInfoSection
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.colors
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.typography


@Composable
fun MinseoRoute(
    navigateToJiwoo: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel: MinseoViewModel = viewModel()
    LaunchedEffect(Unit) {
        viewModel.getScrapList()
    }
    val scrapList = viewModel.scrapList

    MinseoScreen(
        scrapList = scrapList,
        navigateToJiwoo = navigateToJiwoo,
        modifier = modifier
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
            .background(colors.bg)
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        TopBar(
            topBarText = "스크랩",
            onClickBack = navigateToJiwoo
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "총 " + scrapList.size + "개",
                style = typography.body_spc_14,
                color = colors.dark
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "필터",
                style = typography.caption_12R,
                color = colors.dark
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_setting),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = colors.dark
            )
            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "최신순",
                style = typography.caption_12R,
                color = colors.dark
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_under),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = colors.dark
            )
        }

        LazyColumn(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(scrapList.size) { index ->
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
    HaeMuraTheme {
        MinseoScreen(
            scrapList = listOf(
                ScrapInfo(
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                    foodTitle = "들기름 막국수",
                    location = "경북 의성군 금성면",
                    level = 1,
                    time = "⭐️⭐️⭐️"
                ),
                ScrapInfo(
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                    foodTitle = "들기름 막국수",
                    location = "경북 의성군 금성면",
                    level = 2,
                    time = "⭐️⭐️⭐️"
                )
            ),
            navigateToJiwoo = {}
        )
    }
}