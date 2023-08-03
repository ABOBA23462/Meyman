package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.SanatoriumDto
import com.example.meyman.data.remote.dtos.TravelItemDto
import retrofit2.Response
import retrofit2.http.GET

interface SanatoriumsApiService {

    @GET("travel/sanatoriums/")
    fun fetchSanatoriums(): SanatoriumDto<TravelItemDto>
}