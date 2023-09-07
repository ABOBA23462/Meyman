package com.example.meyman.presentation.models.rooms

import com.example.meyman.core.base.IBaseDiffModel
import com.example.meyman.domain.utils.models.rooms.RoomImagesItemModel
import com.google.gson.annotations.SerializedName

data class RoomImagesItemUI(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("id")
    override val id: Int = 0,
    @SerializedName("room")
    val room: Int = 0
): IBaseDiffModel

fun RoomImagesItemModel.toUI() = RoomImagesItemUI(
    image,
    id,
    room
)