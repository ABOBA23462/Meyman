package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.HostelAmenitiesDto
import com.example.meyman.data.remote.dtos.HostelDto
import com.example.meyman.data.remote.dtos.HostelItemDto
import com.example.meyman.data.remote.dtos.HostelRoomAmenitiesDto
import com.example.meyman.domain.utils.models.HostelModel
import retrofit2.Response
import retrofit2.http.GET

interface HostelsApiServer {

    @GET("api/travel/hostels/")
    fun fetchHostels(): Response<HostelDto>

    @GET("api/travel/hostels/")
    fun fetchHostelsItemDto(): Response<HostelItemDto>

    @GET("api/travel/hostels/")
    fun fetchHostelsAmenitiesDto(): Response<HostelAmenitiesDto>

    @GET("api/travel/hostels/")
    fun fetchHostelsRoomAmenitiesDto(): Response<HostelRoomAmenitiesDto>

}