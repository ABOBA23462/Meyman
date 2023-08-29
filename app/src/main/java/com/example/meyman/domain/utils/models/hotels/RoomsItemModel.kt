package com.example.meyman.domain.utils.models.hotels

data class RoomsItemModel(
    val numRooms: Int = 0,
    val roomAmenities: String = "",
    val maxGuestCapacity: Int = 0,
    val bedType: String = "",
    val pricePerNight: String = "",
    val roomArea: Int = 0,
    val roomImages: List<RoomImagesItemModel>?
)