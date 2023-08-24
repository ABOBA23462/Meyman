package com.example.meyman.data.remote.dtos.rooms

import com.example.meyman.domain.utils.models.rooms.RoomImagesItemModel
import com.squareup.moshi.Json

data class RoomImagesItemDto(@Json(name = "room_image")
                          val roomImage: String = "",
                          @Json(name = "id")
                          val id: Int = 0,
                          @Json(name = "room")
                          val room: Int = 0)

fun RoomImagesItemDto.toDomain() = RoomImagesItemModel(
    roomImage,
    id,
    room
)