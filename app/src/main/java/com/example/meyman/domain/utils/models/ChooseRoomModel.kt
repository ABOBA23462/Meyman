package com.example.meyman.domain.utils.models


data class ChooseRoomModel(
    val bed_type: String,
    val id: Int,
    val max_guest_capacity: Int,
    val num_rooms: Int,
    val price_per_night: String,
    val room_amenities: List<String>,
    val room_area: Int,
    val room_images: List<RoomImageDomain>
)

data class RoomImageDomain(
    val id: Int,
    val image: String,
    val room: Int
)