package org.sopt.a36_sopkathon_android_android3.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val status: Int,
    val message: String,
    val data: T? = null,
)