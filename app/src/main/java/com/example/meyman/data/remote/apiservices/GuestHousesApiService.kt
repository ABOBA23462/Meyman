package com.example.meyman.data.remote.apiservices


import com.example.meyman.data.remote.dtos.GuestHouseDto
import com.example.meyman.data.remote.dtos.TravelItemDto
import retrofit2.http.GET

interface GuestHousesApiService {

    @GET("travel/guest-houses/")
    fun fetchGustHouses(): GuestHouseDto<TravelItemDto>
}