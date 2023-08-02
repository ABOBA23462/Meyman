package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.HotelDto
import com.example.meyman.data.remote.dtos.TravelItemDto
import retrofit2.http.GET

interface HotelApiServer {

    @GET("api/travel/hotels/")
    fun fetchHotel(): HotelDto<TravelItemDto>
}