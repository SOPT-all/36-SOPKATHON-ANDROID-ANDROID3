package org.sopt.a36_sopkathon_android_android3.data.util

import org.sopt.a36_sopkathon_android_android3.data.dto.response.ApiResponse

fun <T> ApiResponse<T>.handleApiResponse(): Result<T> {
    return when (this.status) {
        in 200..299 -> {
            if (this.data != null) {
                Result.success(this.data)
            } else {
                Result.failure(Exception("No data available"))
            }
        }

        in 300..399 -> {
            Result.failure(Exception("Redirection error: ${this.message}"))
        }

        in 400..499 -> {
            Result.failure(Exception("Client error: ${this.message}"))
        }

        in 500..599 -> {
            Result.failure(Exception("Server error: ${this.message}"))
        }

        else -> {
            Result.failure(Exception("Unexpected error: ${this.message}"))
        }
    }
}
