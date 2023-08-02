package com.example.meyman.data.remote.apiservices


import com.example.meyman.data.remote.dtos.GuestHouseAmenitiesDto
import com.example.meyman.data.remote.dtos.GuestHouseDto
import com.example.meyman.data.remote.dtos.GuestHouseItemDto
import com.example.meyman.data.remote.dtos.GuestRoomAmenitiesDto
import retrofit2.Response
import retrofit2.http.GET

interface GuestHousesApiServer {

    @GET("api/travel/guest-houses/")
    fun fetchGustHouses(): Response<GuestHouseDto>

    @GET("api/travel/guest-houses/")
    fun fetchGustHousesItemDto(): Response<GuestHouseItemDto>

    @GET("api/travel/guest-houses/")
    fun fetchGustHousesAmenitiesDto(): Response<GuestHouseAmenitiesDto>

    @GET("api/travel/guest-houses/")
    fun fetchGustHousesRoomAmenitiesDto(): Response<GuestRoomAmenitiesDto>

}