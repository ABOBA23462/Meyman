package com.example.meyman.presentation.models

import com.example.meyman.core.base.IBaseDiffModel
import com.example.meyman.domain.utils.models.ChooseRoomModel
import com.example.meyman.domain.utils.models.ResultDomain
import com.example.meyman.domain.utils.models.RoomImageDomain
import com.google.gson.annotations.SerializedName

data class ChooseRoomUI(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: Any,
    @SerializedName("previous") val previous: Any,
    @SerializedName("results") val results: List<ResultRoomUI>
)

fun ChooseRoomModel.toUI() =
    ChooseRoomUI(count, next, previous, results.map { it.toUI() })

data class ResultRoomUI(
    @SerializedName("bed_type")
    val bedType: List<String>?,
    @SerializedName("id")
        val id: Int,
    @SerializedName("max_guest_capacity")
        val max_guest_capacity: Int,
    @SerializedName("num_rooms")
        val num_rooms: Int,
    @SerializedName("price_per_night")
        val price_per_night: String,
    @SerializedName("room_amenities")
        val room_amenities: List<String>,
    @SerializedName("room_area")
        val room_area: Int,
    @SerializedName("room_images")
        val room_images: List<RoomImageUI>
)

fun ResultDomain.toUI() = ResultRoomUI(
    bedType,
    id,
    max_guest_capacity,
    num_rooms,
    price_per_night,
    room_amenities,
    room_area,
    room_images.map { it.toUI() })

data class RoomImageUI(
    @SerializedName("id") override val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("room") val room: Int
): IBaseDiffModel


fun RoomImageDomain.toUI() = RoomImageUI(
    id, image, room
)

