package com.example.meyman.domain.utils.models.rooms

import com.google.gson.annotations.SerializedName

data class ResultsRoomsItemModel(
    val numRooms: Int = 0,
    val roomAmenities: List<String>?,
    val maxGuestCapacity: Int = 0,
    val bedType: List<String>?,
    val pricePerNight: String = "",
    val roomArea: Int = 0,
    val roomImages: List<RoomImagesItemModel>?
)