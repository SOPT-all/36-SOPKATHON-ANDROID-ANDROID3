package org.sopt.a36_sopkathon_android_android3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponseDto(
    @SerialName("code")
    val code: Int,
    @SerialName("Recipe")
    val Recipe: Recipe,
    @SerialName("message")
    val message: String
)

@Serializable
data class Recipe(
    @SerialName("ingredients")
    val ingredients: List<Ingredient>,
    @SerialName("owner_id")
    val owner_id: Int,
    @SerialName("owner_image")
    val owner_image: String,
    @SerialName("owner_name")
    val owner_name: String,
    @SerialName("owner_residence")
    val owner_residence: String,
    @SerialName("recipe_id")
    val recipe_id: Int,
    @SerialName("recipe_level")
    val recipe_level: String,
    @SerialName("recipe_scrap")
    val recipe_scrap: Boolean,
    @SerialName("recipe_story")
    val recipe_story: String,
    @SerialName("recipe_time")
    val recipe_time: Int,
    @SerialName("recipe_title")
    val recipe_title: String,
    @SerialName("recommends")
    val recommends: List<Recommend>,
    @SerialName("reviews")
    val reviews: List<Review>,
    @SerialName("story_id")
    val story_id: Int,
    @SerialName("thumbnail_image")
    val thumbnail_image: String,
    @SerialName("thumbnail_url")
    val thumbnail_url: String
)

@Serializable
data class Ingredient(
    @SerialName("ingredient_amount")
    val ingredient_amount: String,
    @SerialName("ingredient_id")
    val ingredient_id: Int,
    @SerialName("ingredient_image")
    val ingredient_image: String,
    @SerialName("ingredient_name")
    val ingredient_name: String
)

@Serializable
data class Review(
    @SerialName("review_content")
    val review_content: String,
    @SerialName("review_id")
    val review_id: Int
)

@Serializable
data class Recommend(
    @SerialName("recommend_id")
    val recommend_id: Int,
    @SerialName("recomment_item_price")
    val recomment_item_price: Int,
    @SerialName("recoomend_img")
    val recoomend_img: String,
    @SerialName("recoomend_store_url")
    val recoomend_store_url: String
)