package org.sopt.a36_sopkathon_android_android3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoryResponseDto(
    @SerialName("storyId")
    val storyId: Int,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("title")
    val title: String,
    @SerialName("story")
    val story: String,
)
