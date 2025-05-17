package org.sopt.a36_sopkathon_android_android3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDto(
    @SerialName("ingredients")
    val ingredients: List<IngredientDto> = emptyList(),
    @SerialName("owner_id")
    val ownerId: Int = 0,
    @SerialName("owner_image")
    val ownerImage: String = "",
    @SerialName("owner_name")
    val ownerName: String = "",
    @SerialName("owner_residence")
    val ownerResidence: String = "",
    @SerialName("recipe_id")
    val recipeId: Int = 0,
    @SerialName("recipe_level")
    val recipeLevel: Int = 0,
    @SerialName("recipe_scrap")
    val recipeScrap: Boolean = false,
    @SerialName("recipe_story")
    val recipeStory: String = "",
    @SerialName("recipe_time")
    val recipeTime: String = "",
    @SerialName("recipe_title")
    val recipeTitle: String = "",
    @SerialName("local_ingredients")
    val localIngredients: List<IngredientDto> = emptyList(),
    @SerialName("recommends")
    val recommends: List<RecommendDto> = emptyList(),
    @SerialName("reviews")
    val reviews: List<ReviewDto> = emptyList(),
    @SerialName("recipe")
    val recipe: List<String> = emptyList(),
    @SerialName("story_id")
    val storyId: Int = 0,
    @SerialName("thumbnail_image")
    val thumbnailImage: String = "",
    @SerialName("thumbnail_url")
    val thumbnailUrl: String = ""
)

@Serializable
data class IngredientDto(
    @SerialName("local_ingredients_amount")
    val ingredientAmount: String = "",
    @SerialName("local_ingredients_id")
    val ingredientId: Int = 0,
    @SerialName("local_ingredients_name")
    val ingredientName: String = "",
    @SerialName("local_ingredients_image")
    val localIngredientsImage: String = "",
)

@Serializable
data class ReviewDto(
    @SerialName("review_content")
    val reviewContent: String = "",
    @SerialName("review_id")
    val reviewId: Int = 0
)

@Serializable
data class RecommendDto(
    @SerialName("recommend_id")
    val recommendId: Int = 0,
    @SerialName("recommend_item_price")
    val recommendItemPrice: Int = 0,
    @SerialName("recommend_img")
    val recommendImg: String = "",
    @SerialName("recommend_store")
    val recommendStore: String = "",
    @SerialName("recommend_store_url")
    val recommendStoreUrl: String = ""
)
