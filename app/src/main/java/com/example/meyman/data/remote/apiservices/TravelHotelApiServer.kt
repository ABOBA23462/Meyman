package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.HotelItemDto
import retrofit2.Call
import retrofit2.http.GET

interface TravelHotelApiServer {

    @GET("api/travel/hotels/")
    fun fetchTravelHotel(): Call<HotelItemDto>

}