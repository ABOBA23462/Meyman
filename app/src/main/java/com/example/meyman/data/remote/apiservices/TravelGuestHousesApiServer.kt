package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.GuestHouseItemDto
import retrofit2.Call
import retrofit2.http.GET

interface TravelGuestHousesApiServer {

    @GET("api/travel/guest-houses/")
    fun fetchTravelGustHouses():Call<GuestHouseItemDto>

}