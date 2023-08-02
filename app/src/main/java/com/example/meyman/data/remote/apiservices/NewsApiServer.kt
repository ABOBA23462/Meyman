package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.NewsDto
import com.example.meyman.data.remote.dtos.NewsItemDto
import retrofit2.Response
import retrofit2.http.GET

interface NewsApiServer {

    @GET("api/news/news/")
    fun fetchNewsDto(): Response<NewsDto>

    @GET("api/news/news/")
    fun fetchNewsItemDto(): Response<NewsItemDto>
}
