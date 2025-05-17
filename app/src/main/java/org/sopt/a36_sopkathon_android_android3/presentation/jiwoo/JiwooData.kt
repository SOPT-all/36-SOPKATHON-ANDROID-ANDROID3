package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo

import org.sopt.a36_sopkathon_android_android3.data.dto.response.IngredientDto
import org.sopt.a36_sopkathon_android_android3.data.dto.response.RecipeDto
import org.sopt.a36_sopkathon_android_android3.data.dto.response.RecommendDto
import org.sopt.a36_sopkathon_android_android3.data.dto.response.ReviewDto

data class RecipeData(
    val recipeId: Int = 0,
    val thumbnailImage: String = "",
    val thumbnailUrl: String = "",
    val recipeTitle: String = "",
    val recipeLevel: Int = 0,
    val recipeTime: String = "",
    val recipeScrap: Boolean = false,
    val ingredients: List<Ingredient> = emptyList(),
    val ownerId: Int = 0,
    val ownerName: String = "",
    val ownerImage: String = "",
    val ownerResidence: String = "",
    val recipeSteps: List<String> = emptyList(),
    val storyId: Int = 0,
    val recipeStory: String = "",
    val recipe: List<String> = emptyList(),
    val recipeSmallTitle: String = "",
    val reviews: List<Review> = emptyList(),
    val recommends: List<Recommend> = emptyList(),
    val localIngredients: List<Ingredient>
)

data class Ingredient(
    val ingredientId: Int = 0,
    val ingredientName: String = "",
    val ingredientAmount: String = "",
    val localIngredientsImage: String = ""
)

data class Review(
    val reviewId: Int = 0,
    val reviewContent: String = ""
)

data class Recommend(
    val recommendId: Int = 0,
    val recommendItemPrice: Int = 0,
    val recommendImg: String = "",
    val recommendStore: String = "",
    val recommendStoreUrl: String = ""
)

data class LocalIngredient(
    val localIngredientsId: Int = 0,
    val localIngredientsImage: String = "",
    val localIngredientsName: String = "",
    val localIngredientsAmount: String = ""
)


fun RecipeDto.toDomain(): RecipeData {
    return RecipeData(
        ingredients = ingredients.map { it.toDomain() },
        ownerId = ownerId,
        ownerImage = ownerImage,
        ownerName = ownerName,
        ownerResidence = ownerResidence,
        recipeId = recipeId,
        recipeLevel = recipeLevel,
        recipeScrap = recipeScrap,
        recipeStory = recipeStory,
        recipeTime = recipeTime,
        recipeTitle = recipeTitle,
        recipe = recipe,
        recommends = recommends.map { it.toDomain() },
        reviews = reviews.map { it.toDomain() },
        storyId = storyId,
        localIngredients = localIngredients.map { it.toDomain() },
        thumbnailImage = thumbnailImage,
        thumbnailUrl = thumbnailUrl
    )
}

fun IngredientDto.toDomain(): Ingredient {
    return Ingredient(
        ingredientId = ingredientId,
        ingredientName = ingredientName,
        ingredientAmount = ingredientAmount,
        localIngredientsImage = localIngredientsImage
    )
}

fun ReviewDto.toDomain(): Review {
    return Review(
        reviewContent = reviewContent,
        reviewId = reviewId
    )
}

fun RecommendDto.toDomain(): Recommend {
    return Recommend(
        recommendId = recommendId,
        recommendItemPrice = recommendItemPrice,
        recommendImg = recommendImg,
        recommendStore = recommendStore,
        recommendStoreUrl = recommendStoreUrl
    )
}

fun LocalIngredient.toDomain(): LocalIngredient {
    return LocalIngredient(
        localIngredientsId = localIngredientsId,
        localIngredientsImage = localIngredientsImage,
        localIngredientsName = localIngredientsName,
        localIngredientsAmount = localIngredientsAmount
    )
}
