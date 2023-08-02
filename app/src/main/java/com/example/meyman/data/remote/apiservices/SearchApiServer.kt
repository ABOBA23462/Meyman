package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.SearchDto
import com.example.meyman.data.remote.dtos.SearchItemDto
import retrofit2.Response
import retrofit2.http.GET

interface SearchApiServer {

    @GET("api/travel_search/")
    fun fetchServiceSearch(): Response<SearchDto>

    @GET("api/travel_search/")
    fun fetchServiceSearchItemDto(): Response<SearchItemDto>
}