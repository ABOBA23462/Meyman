package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.HostelDto
import com.example.meyman.data.remote.dtos.TravelItemDto
import retrofit2.http.GET

interface HostelsApiService {

    @GET("travel/hostels/")
    fun fetchHostels(): HostelDto<TravelItemDto>
}