package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.ChooseRoomModel
import com.example.meyman.domain.utils.models.ResultDomain
import com.example.meyman.domain.utils.models.RoomImageDomain
import com.google.gson.annotations.SerializedName

data class ChooseRoomDto(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: Any,
    @SerializedName("previous") val previous: Any,
    @SerializedName("results") val results: List<Result>
)

fun ChooseRoomDto.toChooseRoomDomain() =
    ChooseRoomModel(count, next, previous, results.map { it.toRoomDomain() })

data class Result(
    @SerializedName("bed_type") val bed_type: String,
    @SerializedName("id") val id: Int,
    @SerializedName("max_guest_capacity") val max_guest_capacity: Int,
    @SerializedName("num_rooms") val num_rooms: Int,
    @SerializedName("price_per_night") val price_per_night: String,
    @SerializedName("room_amenities") val room_amenities: List<String>,
    @SerializedName("room_area") val room_area: Int,
    @SerializedName("room_images") val room_images: List<RoomImage>
)

fun Result.toRoomDomain() = ResultDomain(bed_type,
    id,
    max_guest_capacity,
    num_rooms,
    price_per_night,
    room_amenities,
    room_area,
    room_images.map { it.toDomain() })

data class RoomImage(
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("room") val room: Int
)


fun RoomImage.toDomain() = RoomImageDomain(
    id, image, room
)
