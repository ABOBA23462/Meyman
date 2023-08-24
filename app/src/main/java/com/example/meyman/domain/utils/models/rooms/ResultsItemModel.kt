package com.example.meyman.domain.utils.models.rooms

data class ResultsItemModel(
    val kingBed: Int = 0,
    val roomAmenities: List<String>?,
    val queenBed: Int = 0,
    val maxGuestCapacity: Int = 0,
    val smokingAllowed: Boolean = false,
    val housing: Int = 0,
    val bedType: String = "",
    val roomArea: Int = 0,
    val withoutCard: Boolean = false,
    val numRooms: Int = 0,
    val bedrooms: String = "",
    val roomName: String = "",
    val freeCancellation: Boolean = false,
    val singleBed: Int = 0,
    val sofaBed: Int = 0,
    val pricePerNight: String = "",
    val roomImages: List<RoomImagesItemModel>?,
    val payment: String = "",
    val id: Int = 0,
    val doubleBed: Int = 0,
    val policy: String = ""
)