package com.example.meyman.data.remote.dtos.rooms

import com.example.meyman.domain.utils.models.rooms.ResultsItemModel
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class ResultsItemDto(
    @SerializedName("king_bed")
    val kingBed: Int = 0,
    @SerializedName ("room_amenities")
    val roomAmenities: List<String>?,
    @SerializedName ("queen_bed")
    val queenBed: Int = 0,
    @SerializedName ("max_guest_capacity")
    val maxGuestCapacity: Int = 0,
    @SerializedName ("smoking_allowed")
    val smokingAllowed: Boolean = false,
    @SerializedName ("housing")
    val housing: Int = 0,
    @SerializedName ("bed_type")
    val bedType: String = "",
    @SerializedName ("room_area")
    val roomArea: Int = 0,
    @SerializedName ("without_card")
    val withoutCard: Boolean = false,
    @SerializedName ("num_rooms")
    val numRooms: Int = 0,
    @SerializedName ("bedrooms")
    val bedrooms: String = "",
    @SerializedName ("room_name")
    val roomName: String = "",
    @SerializedName ("free_cancellation")
    val freeCancellation: Boolean = false,
    @SerializedName ("single_bed")
    val singleBed: Int = 0,
    @SerializedName ("sofa_bed")
    val sofaBed: Int = 0,
    @SerializedName ("price_per_night")
    val pricePerNight: String = "",
    @SerializedName ("room_images")
    val roomImages: List<RoomImagesItemDto>?,
    @SerializedName ("payment")
    val payment: String = "",
    @SerializedName ("id")
    val id: Int = 0,
    @SerializedName ("double_bed")
    val doubleBed: Int = 0,
    @SerializedName ("policy")
    val policy: String = ""
)

fun ResultsItemDto.toDomain() = ResultsItemModel(
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
    roomImages = roomImages?.map { it.toDomain() },
    payment,
    id,
    doubleBed,
    policy

)