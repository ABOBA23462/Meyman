package com.example.meyman.domain.utils.models

data class ChooseRoomModel(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<ResultDomain>
)

data class ResultDomain(
    val bed_type: String,
    val id: Int,
    val max_guest_capacity: Int,
    val num_rooms: Int,
    val price_per_night: String,
    val room_amenities: List<String>,
    val room_area: Int,
    val room_images: List<RoomImage>
)

data class RoomImage(
    val id: Int,
    val image: String,
    val room: Int
)