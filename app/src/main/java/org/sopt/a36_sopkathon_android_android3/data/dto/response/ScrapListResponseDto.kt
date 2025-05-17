package org.sopt.a36_sopkathon_android_android3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScrapListResponseDto(
    @SerialName("total_scrap_count")
    val total_scrap_count: Int,
    @SerialName("recipe_list")
    val recipe_list: List<RecipeListDto>
)

@Serializable
data class RecipeListDto(
    @SerialName("recipe_id")
    val recipe_id: Int,
    @SerialName("recipe_owner_address")
    val recipe_owner_address: String,
    @SerialName("recipe_name")
    val recipe_name: String,
    @SerialName("thumbnail_image")
    val thumbnail_image: String,
    @SerialName("recipe_level")
    val recipe_level: Int,
    @SerialName("recipe_time")
    val recipe_time: String
)