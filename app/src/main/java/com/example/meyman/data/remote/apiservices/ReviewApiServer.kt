package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.ReviewDto
import com.example.meyman.data.remote.dtos.ReviewItemDto
import retrofit2.Response
import retrofit2.http.GET

interface ReviewApiServer {

    @GET("api/review/review/")
    fun fetchReviewDto(): Response<ReviewDto>

    @GET("api/review/review/")
    fun fetchReviewItemDto(): Response<ReviewItemDto>

}