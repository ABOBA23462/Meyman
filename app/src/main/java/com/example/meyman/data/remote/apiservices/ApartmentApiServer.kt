package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.ApartmentDto
import com.example.meyman.data.remote.dtos.TravelItemDto
import retrofit2.http.GET

interface ApartmentApiServer {

    @GET("api/travel/apartment/")
    fun fetchApartment(): ApartmentDto<TravelItemDto>
}