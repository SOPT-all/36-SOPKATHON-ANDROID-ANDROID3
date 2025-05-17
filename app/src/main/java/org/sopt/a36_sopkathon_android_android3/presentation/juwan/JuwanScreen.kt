package org.sopt.a36_sopkathon_android_android3.presentation.juwan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.a36_sopkathon_android_android3.presentation.juwan.component.HomeCardView
import org.sopt.a36_sopkathon_android_android3.presentation.juwan.component.HomeTopBar
import org.sopt.a36_sopkathon_android_android3.presentation.juwan.component.SearchBar
import org.sopt.a36_sopkathon_android_android3.presentation.minseo.ScrapInfo
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.colors


@Composable
fun JuwanRoute(
    navigateToDongmin: () -> Unit,
) {
    val homeList = JuwanViewModel().homeList
    JuwanScreen(
        navigateToDongmin = navigateToDongmin,
        homeList = homeList
    )
}

@Composable
private fun JuwanScreen(
    navigateToDongmin: () -> Unit,
    homeList: List<homeItem>,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp)
            .background(color =colors.bg)
            .fillMaxSize()

    ) {
        HomeTopBar()
        Text(
            text = "해무리의 장독대\n오늘은 어느 마을의 맛을 알아볼까요?",
            style = HaeMuraTheme.typography.head_spc_24
        )
        SearchBar(value = "")

        Spacer(modifier = Modifier.height(21.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(11.dp),
            verticalArrangement = Arrangement.spacedBy(11.dp)

        ) {
            items(homeList.size){ index ->
                HomeCardView(
                    homeItem = homeList[index]
                )
            }
        }

    }





}

@Preview(showBackground = true)
@Composable
private fun PreviewJuwanScreen() {
   HaeMuraTheme {
        JuwanScreen(
            homeList = listOf(
                homeItem(
                    homeId = "1",
                    text = "상주",
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400"
                ),
                homeItem(
                    homeId = "2",
                    text = "의성",
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400"
                ),
                homeItem(
                    homeId = "3",
                    text = "안동",
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400"
                )
            ),
            navigateToDongmin = {}
        )
    }
}