package org.sopt.a36_sopkathon_android_android3.data.service

import org.sopt.a36_sopkathon_android_android3.data.dto.response.ApiResponse
import org.sopt.a36_sopkathon_android_android3.data.dto.response.RecipeDto
import retrofit2.http.GET
import retrofit2.http.Path


interface JiwooService {
    @GET("api/v1/recipe/{recipe_id}")
    suspend fun getRecipeData(
        @Path("recipe_id")
        recipeId: Int
    ): ApiResponse<RecipeDto>
}
