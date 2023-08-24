package com.example.meyman.data.remote.dtos.rooms

import com.example.meyman.domain.utils.models.rooms.RoomImagesItemModel
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

    data class RoomImagesItemDto(@SerializedName ("room_image")
                          val roomImage: String = "",
                          @SerializedName("id")
                          val id: Int = 0,
                          @SerializedName("room")
                          val room: Int = 0)

fun RoomImagesItemDto.toDomain() = RoomImagesItemModel(
    roomImage,
    id,
    room
)