package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.SanatoriumItemDto
import retrofit2.Call
import retrofit2.http.GET

interface TravelSanatoriumsApiServer {

    @GET("api/travel/sanatoriums/")
    fun fetchTravelSanatoriums(): Call<SanatoriumItemDto>

}