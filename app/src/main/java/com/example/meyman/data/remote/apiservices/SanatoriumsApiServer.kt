package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.SanatoriumAmenitiesDto
import com.example.meyman.data.remote.dtos.SanatoriumDto
import com.example.meyman.data.remote.dtos.SanatoriumItemDto
import com.example.meyman.data.remote.dtos.SanatoriumRoomAmenitiesDto
import retrofit2.Response
import retrofit2.http.GET

interface SanatoriumsApiServer {

    @GET("api/travel/sanatoriums/")
    fun fetchSanatoriums(): Response<SanatoriumDto>

    @GET("api/travel/sanatoriums/")
    fun fetchSanatoriumsItemDto(): Response<SanatoriumItemDto>

    @GET("api/travel/sanatoriums/")
    fun fetchSanatoriumsAmenitiesDto(): Response<SanatoriumAmenitiesDto>

    @GET("api/travel/sanatoriums/")
    fun fetchSanatoriumsRoomAmenitiesDto(): Response<SanatoriumRoomAmenitiesDto>

}