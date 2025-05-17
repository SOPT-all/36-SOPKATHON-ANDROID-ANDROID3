package org.sopt.a36_sopkathon_android_android3.data.service

import org.sopt.a36_sopkathon_android_android3.data.dto.request.ExampleRequestDto
import org.sopt.a36_sopkathon_android_android3.data.dto.response.ApiResponse
import org.sopt.a36_sopkathon_android_android3.data.dto.response.ExampleResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ExampleService {
    @GET("api/v1/data")
    suspend fun getExampleData(): ApiResponse<ExampleResponseDto>

    @POST("api/v1/data")
    suspend fun postExampleData(
        @Body exampleRequestDto: ExampleRequestDto,
    ): ApiResponse<Unit>
}