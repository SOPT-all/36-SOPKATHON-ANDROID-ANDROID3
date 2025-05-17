package org.sopt.a36_sopkathon_android_android3.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExampleRequestDto(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
)