package org.sopt.a36_sopkathon_android_android3.data.service

import org.sopt.a36_sopkathon_android_android3.data.dto.response.ApiResponse
import org.sopt.a36_sopkathon_android_android3.data.dto.response.Recipe
import org.sopt.a36_sopkathon_android_android3.data.dto.response.RecipeResponseDto
import retrofit2.http.GET


interface JiwooService {
    @GET("api/v1/recipe")
    suspend fun getRecipeData(): ApiResponse<RecipeResponseDto>
}