package org.sopt.a36_sopkathon_android_android3.data.service

import org.sopt.a36_sopkathon_android_android3.data.dto.response.ApiResponse
import org.sopt.a36_sopkathon_android_android3.data.dto.response.ScrapListResponseDto
import retrofit2.http.GET

interface MinseoService {
    @GET("api/v1/scrap")
    suspend fun getScrapList(): ApiResponse<ScrapListResponseDto>
}