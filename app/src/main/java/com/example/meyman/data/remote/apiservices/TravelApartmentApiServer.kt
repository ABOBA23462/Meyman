package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.ApartmentItemDto
import retrofit2.Call
import retrofit2.http.GET

interface TravelApartmentApiServer {

    @GET("api/travel/apartment/")
    fun fetchTravelApartment(): Call<ApartmentItemDto>
}