package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.rooms.ResultsRoomsItemDto
import com.example.meyman.data.remote.dtos.rooms.list.RoomListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RoomsApiService {

    @GET("api/housing/rooms/")
    suspend fun fetchRooms(): RoomListDto

    @GET("api/housing/rooms/{id}/")
    suspend fun fetchDetailRoom(
        @Path("id") id: Int
    ): Response<ResultsRoomsItemDto>
}