package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.ChooseRoomDto
import com.example.meyman.data.remote.dtos.rooms.ResultsRoomsItemDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.CompletableFuture

interface RoomsApiService {

    @GET("rooms/")
    suspend fun fetchRooms(): ChooseRoomDto

    @GET("rooms/{id}/")
    suspend fun fetchDetailRoom(
        @Path("id") id: Int
    ): Response<ResultsRoomsItemDto>
}