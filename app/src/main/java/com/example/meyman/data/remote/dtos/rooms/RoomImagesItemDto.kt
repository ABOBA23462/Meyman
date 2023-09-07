package com.example.meyman.data.remote.dtos.rooms

import com.example.meyman.domain.utils.models.rooms.RoomImagesItemModel
import com.google.gson.annotations.SerializedName

data class RoomImagesItemDto(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("room")
    val room: Int = 0
)

fun RoomImagesItemDto.toDomain() = RoomImagesItemModel(
    image,
    id,
    room
)