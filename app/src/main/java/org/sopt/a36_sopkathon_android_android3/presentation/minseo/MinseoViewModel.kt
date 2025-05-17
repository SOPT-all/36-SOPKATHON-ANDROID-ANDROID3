package org.sopt.a36_sopkathon_android_android3.presentation.minseo

import androidx.lifecycle.ViewModel

class MinseoViewModel : ViewModel() {
}

data class ScrapInfo(
    val imageUrl: String,
    val title: String,
    val content: String
)