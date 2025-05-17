package org.sopt.a36_sopkathon_android_android3.presentation.juwan.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SearchBar(
    modifier : Modifier = Modifier,
    value : String,
    singleLine : Boolean = true

) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            ,
        value = "",
        singleLine = true,
        onValueChange = {

            val query = it.trim()

        },
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = "Search Icon"
            )
        },
        placeholder = {
            Text(
                text = "찾고 싶은 마을을 입력해보세요",
                fontWeight = FontWeight.Thin
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
fun previewSearchBar(){
    SearchBar(value ="")
}