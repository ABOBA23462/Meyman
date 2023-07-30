package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.ReviewItemDto
import retrofit2.Call
import retrofit2.http.GET

interface ReviewApiServer {

    @GET("api/review/review/")
    fun fetchReview(): Call<ReviewItemDto>

}