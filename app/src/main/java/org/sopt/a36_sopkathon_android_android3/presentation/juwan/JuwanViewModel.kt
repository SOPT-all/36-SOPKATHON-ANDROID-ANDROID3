package org.sopt.a36_sopkathon_android_android3.presentation.juwan

import androidx.lifecycle.ViewModel
import org.sopt.a36_sopkathon_android_android3.presentation.minseo.ScrapInfo

class JuwanViewModel : ViewModel() {

    val homeList = listOf(
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

    )
}

data class homeItem(
    val homeId: String,
    val text: String,
    val imageUrl: String,
)