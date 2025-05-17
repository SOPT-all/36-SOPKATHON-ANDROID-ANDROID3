package org.sopt.a36_sopkathon_android_android3.presentation.minseo

import androidx.lifecycle.ViewModel

class MinseoViewModel : ViewModel() {
    val scrapList = listOf(
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
        ),
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
    )
}

data class ScrapInfo(
    val imageUrl: String,
    val foodTitle: String,
    val location: String,
    val level: String,
    val time: String
)