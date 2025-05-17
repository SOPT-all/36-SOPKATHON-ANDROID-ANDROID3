package org.sopt.a36_sopkathon_android_android3.presentation.juwan.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.presentation.juwan.homeItem
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.colors


@Composable
fun HomeCardView(
    homeItem: homeItem,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .border(width = 1.dp, color = Color.Transparent, shape = RoundedCornerShape(10.dp))
            .background(colors.white)
            .padding(horizontal = 20.dp, vertical = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.run { spacedBy(11.dp) }

    ) {
        AsyncImage(
            model = homeItem.image,
            contentDescription = homeItem.homeId,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Text(
            text = homeItem.text,
            style = HaeMuraTheme.typography.head_spc_16,
            color = colors.dark
        )
    }

}


@Preview(showBackground = true)
@Composable
fun showCardView() {
    HomeCardView(
        homeItem =
            homeItem(
                homeId = "1",
                text = "상주",
                image = R.drawable.img_home_1
            )
    )
}