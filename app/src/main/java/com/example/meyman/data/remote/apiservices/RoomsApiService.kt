package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.rooms.ResultsItemDto
import com.example.meyman.data.remote.dtos.rooms.RoomsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RoomsApiService {

    @GET("travel/rooms")
    fun fetchRooms(): RoomsDto<ResultsItemDto>

    @GET("travel/room/{id}")
    fun fetchDetailRoom(
        @Path("id") id: Int
    ): ResultsItemDto
}