package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.HotelAmenitiesDto
import com.example.meyman.data.remote.dtos.HotelDto
import com.example.meyman.data.remote.dtos.HotelItemDto
import com.example.meyman.data.remote.dtos.HotelRoomAmenitiesDto
import retrofit2.Response
import retrofit2.http.GET

interface HotelApiServer {

    @GET("api/travel/hotels/")
    fun fetchHotel(): Response<HotelDto>

    @GET("api/travel/hotels/")
    fun fetchHotelItemDto(): Response<HotelItemDto>

    @GET("api/travel/hotels/")
    fun fetchHotelAmenitiesDto(): Response<HotelAmenitiesDto>

    @GET("api/travel/hotels/")
    fun fetchHotelRoomAmenitiesDto(): Response<HotelRoomAmenitiesDto>

}