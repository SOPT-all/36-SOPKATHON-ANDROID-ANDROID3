package org.sopt.a36_sopkathon_android_android3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoryResponseDto(
    @SerialName("recipe_id")
    val recipeId: Int,

    @SerialName("recipe_image")
    val recipeImage: String,

    @SerialName("recipe_owner")
    val recipeOwner: RecipeOwner,

    @SerialName("recipe_name")
    val recipeName: String,

    @SerialName("recipe_small_title")
    val recipeSmallTitle: String,

    @SerialName("recipe_story")
    val recipeStory: String,

    @SerialName("recipe_level")
    val recipeLevel: Int,

    @SerialName("cooking_time")
    val cookingTime: String
) {
    @Serializable
    data class RecipeOwner(
        @SerialName("recipe_owner_image")
        val recipeOwnerImage: String,

        @SerialName("recipe_owner_name")
        val recipeOwnerName: String,

        @SerialName("recipe_owner_address")
        val recipeOwnerAddress: String
    )
}
