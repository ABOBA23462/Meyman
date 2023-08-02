package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.ApartmentAmenitiesDto
import com.example.meyman.data.remote.dtos.ApartmentDto
import com.example.meyman.data.remote.dtos.ApartmentItemDto
import com.example.meyman.data.remote.dtos.ApartmentRoomAmenitiesDto
import retrofit2.Response
import retrofit2.http.GET

interface ApartmentApiServer {

    @GET("api/travel/apartment/")
    fun fetchApartment(): Response<ApartmentDto>

    @GET("api/travel/apartment/")
    fun fetchApartmentItemDto(): Response<ApartmentItemDto>

    @GET("api/travel/apartment/")
    fun fetchApartmentAmenitiesDto(): Response<ApartmentAmenitiesDto>

    @GET("api/travel/apartment/")
    fun fetchApartmentRoomAmenitiesDto(): Response<ApartmentRoomAmenitiesDto>
}