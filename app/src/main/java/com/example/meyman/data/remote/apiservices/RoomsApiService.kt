package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.ChooseRoomDto
import com.example.meyman.data.remote.dtos.rooms.ResultsItemDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RoomsApiService {

    @GET("rooms/")
    suspend fun fetchRooms(): ChooseRoomDto

    @GET("rooms/{id}/")
     fun fetchDetailRoom(
        @Path("id") id: Int
    ): ResultsItemDto
}