package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.NewsDto
import com.example.meyman.data.remote.dtos.NewsItemDto
import retrofit2.http.GET

interface NewsApiServer {

    @GET("api/news/news/")
    fun fetchNewsDto(): NewsDto<NewsItemDto>
}