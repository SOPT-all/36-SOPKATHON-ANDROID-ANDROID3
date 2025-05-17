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
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.core.ext.noRippleClickable
import org.sopt.a36_sopkathon_android_android3.presentation.juwan.component.HomeCardView
import org.sopt.a36_sopkathon_android_android3.presentation.juwan.component.HomeTopBar
import org.sopt.a36_sopkathon_android_android3.presentation.juwan.component.SearchBar
import org.sopt.a36_sopkathon_android_android3.presentation.minseo.ScrapInfo
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.colors


@Composable
fun JuwanRoute(
    navigateToDongmin: () -> Unit,
    navigateToScrap: () -> Unit,
) {
    val homeList = JuwanViewModel().homeList
    JuwanScreen(
        navigateToDongmin = navigateToDongmin,
        navigateToScrap = navigateToScrap,
        homeList = homeList
    )
}

@Composable
private fun JuwanScreen(
    navigateToDongmin: () -> Unit,
    navigateToScrap: () -> Unit,
    homeList: List<homeItem>,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = Modifier
            .background(color = colors.bg)
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxSize()

    ) {
        HomeTopBar(onClick = navigateToScrap,)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "오늘은 어느 마을의 맛을\n열어볼까요?",
            style = HaeMuraTheme.typography.head_spc_24,
            color = colors.dark
        )
        Spacer(modifier = Modifier.height(15.dp))
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
            items(homeList.size) { index ->
                HomeCardView(
                    homeItem = homeList[index],
                    modifier = Modifier.noRippleClickable(navigateToDongmin)
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
                    image = R.drawable.img_home_1
                ),
                homeItem(
                    homeId = "2",
                    text = "의성",
                    image = R.drawable.img_home_2
                ),
                homeItem(
                    homeId = "3",
                    text = "안동",
                    image = R.drawable.img_home_3
                )
            ),
            navigateToDongmin = {},
            navigateToScrap = {}
        )
    }
}