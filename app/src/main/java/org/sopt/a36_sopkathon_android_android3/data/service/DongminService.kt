package org.sopt.a36_sopkathon_android_android3.data.service

import org.sopt.a36_sopkathon_android_android3.data.dto.response.ApiResponse
import org.sopt.a36_sopkathon_android_android3.data.dto.response.StoryResponseDto
import retrofit2.http.GET

interface DongminService {
    @GET("api/v1/story")
    suspend fun getStoryData(): ApiResponse<StoryResponseDto>
}
