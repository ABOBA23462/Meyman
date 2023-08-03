package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.ReviewDto
import com.example.meyman.data.remote.dtos.ReviewItemDto
import retrofit2.http.GET

interface ReviewApiService {

    @GET("review/review/")
    fun fetchReview(): ReviewDto<ReviewItemDto>
}