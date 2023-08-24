package com.example.meyman.presentation.models.rooms

import com.example.meyman.domain.utils.models.rooms.ResultsItemModel
import com.squareup.moshi.Json

data class ResultsItemUI(
    @Json(name = "king_bed")
    val kingBed: Int = 0,
    @Json(name = "room_amenities")
    val roomAmenities: List<String>?,
    @Json(name = "queen_bed")
    val queenBed: Int = 0,
    @Json(name = "max_guest_capacity")
    val maxGuestCapacity: Int = 0,
    @Json(name = "smoking_allowed")
    val smokingAllowed: Boolean = false,
    @Json(name = "housing")
    val housing: Int = 0,
    @Json(name = "bed_type")
    val bedType: String = "",
    @Json(name = "room_area")
    val roomArea: Int = 0,
    @Json(name = "without_card")
    val withoutCard: Boolean = false,
    @Json(name = "num_rooms")
    val numRooms: Int = 0,
    @Json(name = "bedrooms")
    val bedrooms: String = "",
    @Json(name = "room_name")
    val roomName: String = "",
    @Json(name = "free_cancellation")
    val freeCancellation: Boolean = false,
    @Json(name = "single_bed")
    val singleBed: Int = 0,
    @Json(name = "sofa_bed")
    val sofaBed: Int = 0,
    @Json(name = "price_per_night")
    val pricePerNight: String = "",
    @Json(name = "room_images")
    val roomImages: List<RoomImagesItemUI>?,
    @Json(name = "payment")
    val payment: String = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "double_bed")
    val doubleBed: Int = 0,
    @Json(name = "policy")
    val policy: String = ""
)

fun ResultsItemModel.toUI() = ResultsItemUI(
    kingBed,
    roomAmenities,
    queenBed,
    maxGuestCapacity,
    smokingAllowed,
    housing,
    bedType,
    roomArea,
    withoutCard,
    numRooms,
    bedrooms,
    roomName,
    freeCancellation,
    singleBed,
    sofaBed,
    pricePerNight,
    roomImages = roomImages?.map { it.toUI() },
    payment,
    id,
    doubleBed,
    policy

)