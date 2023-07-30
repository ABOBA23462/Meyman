package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.HostelItemDto
import retrofit2.Call
import retrofit2.http.GET

interface TravelHostelsApiServer {

    @GET("api/travel/hostels/")
    fun fetchTravelHostels(): Call<HostelItemDto>

}