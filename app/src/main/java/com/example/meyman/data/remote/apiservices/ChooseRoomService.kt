package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.ChooseRoomDto
import com.example.meyman.data.remote.dtos.Result
import retrofit2.http.GET

interface ChooseRoomService {

    @GET("/api/travel/rooms/")
    suspend fun getChooseRoom(): ChooseRoomDto

}