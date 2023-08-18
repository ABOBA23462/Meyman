package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.ReviewDto
import com.example.meyman.data.remote.dtos.ReviewItemDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReviewApiService {

    @GET("travel/reviews")
    fun fetchReview(
        @Query(value = "page") page : Int? = null ,
        @Query( value = "page_size") page_size: Int? = null,
        ): ReviewDto<ReviewItemDto>
}