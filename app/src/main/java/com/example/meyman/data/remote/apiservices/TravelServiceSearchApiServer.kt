package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.SearchItemDto
import retrofit2.Call
import retrofit2.http.GET

interface TravelServiceSearchApiServer {

    @GET("api/travel_sevice/search/")
    fun fetchServiceSearch(): Call<SearchItemDto>

}