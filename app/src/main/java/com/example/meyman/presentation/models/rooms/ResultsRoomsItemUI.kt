package com.example.meyman.presentation.models.rooms

import com.example.meyman.domain.utils.models.rooms.ResultsRoomsItemModel
import com.google.gson.annotations.SerializedName

data class ResultsRoomsItemUI(
    @SerializedName("num_rooms")
    val numRooms: Int = 0,
    @SerializedName("room_amenities")
    val roomAmenities: List<String>?,
    @SerializedName("max_guest_capacity")
    val maxGuestCapacity: Int = 0,
    @SerializedName("bed_type")
    val bedType: List<String>?,
    @SerializedName("price_per_night")
    val pricePerNight: String = "",
    @SerializedName("room_area")
    val roomArea: Int = 0,
    @SerializedName("room_images")
    val roomImages: List<RoomImagesItemUI>?
)

fun ResultsRoomsItemModel.toUI() = ResultsRoomsItemUI(
    numRooms,
    roomAmenities,
    maxGuestCapacity,
    bedType,
    pricePerNight,
    roomArea,
    roomImages?.map { it.toUI() }
)