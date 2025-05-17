package org.sopt.a36_sopkathon_android_android3.presentation.juwan.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.colors


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    value: String,
    singleLine: Boolean = true,

    ) {
    var text by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .background(color = colors.white)
            .border(width = 1.dp, color = Color.Transparent, RoundedCornerShape(8.dp))
            .height(42.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start

    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_search_re),
            contentDescription = "Search Icon"
        )
        Text(
            modifier = Modifier
                .padding(start = 12.dp),
            text = "찾고 싶은 마을을 입력해보세요",
            style = HaeMuraTheme.typography.body_14R,
            color = colors.light
        )
    }

//    OutlinedTextField(
//        modifier = Modifier
//            .border(width = 1.dp, color = Color.Transparent)
//            .fillMaxWidth()
//            .padding(8.dp)
//            .background(colors.white)
//
//            ,
//        value = "",
//        singleLine = true,
//        onValueChange = {
//
//            val query = it.trim()
//
//        },
//        leadingIcon = {
//            Icon(
//                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_search),
//                contentDescription = "Search Icon"
//            )
//        },
//        placeholder = {
//            Text(
//                text = "찾고 싶은 마을을 입력해보세요",
//                style = HaeMuraTheme.typography.body_14R,
//                color = colors.light
//            )
//        },
//    )
}

@Preview(showBackground = true)
@Composable
fun previewSearchBar() {
    SearchBar(value = "")
}